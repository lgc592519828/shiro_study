package cn.gcheng.security.realm;

import cn.gcheng.entity.User;
import cn.gcheng.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gcheng.L
 * @create 2019-03-14 18:11
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 身份验证， 模拟数据库访问
     * @param authenToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenToken;

        // 安全数据源中获取User对象
        User user = null;
        try {
            user = userService.findUserByLoginName(token.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            // 帐号不存在
            throw new UnknownAccountException();
        }
        if (user.getLocked()) {
            // 账户被锁定
            throw new IncorrectCredentialsException();
        }
        // 暂时不加salt，以及不使用自定义Matcher进行密码验证
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
    }

    /**
     * 授权验证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


}
