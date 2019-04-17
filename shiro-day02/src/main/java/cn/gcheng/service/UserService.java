package cn.gcheng.service;

import cn.gcheng.entity.User;

/**
 * @author gcheng.L
 * @create 2019-04-11 15:34
 */
public interface UserService extends BaseService<User>{

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     * @throws Exception
     */
    User findUserByLoginName(String username) throws Exception;
}
