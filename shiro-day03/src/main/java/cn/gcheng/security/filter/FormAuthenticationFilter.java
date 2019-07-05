package cn.gcheng.security.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author gcheng.L
 * @create 2019-04-03 18:30
 */
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

    /**
     *  可以创建token，这个方法执行在Realm验证之前,也可以自定义密码加密函数
     * @param request
     * @param response
     * @return
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {

        // 获取表单提交用户名密码
        String username = getUsername(request);
        String password = getPassword(request);

        if (password == null) {
            password = "";
        }

        // 创建token，UsernamePasswordToken构造函数很多，也可以自定义，添加验证码等内容
        return new UsernamePasswordToken(username, password.toCharArray());
    }
}
