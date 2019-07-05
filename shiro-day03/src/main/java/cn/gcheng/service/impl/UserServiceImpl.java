package cn.gcheng.service.impl;

import cn.gcheng.entity.User;
import cn.gcheng.mapper.UserMapper;
import cn.gcheng.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gcheng.L
 * @create 2019-04-11 15:14
 */
@Service(value = "loginUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUserByLoginName(String username)throws Exception{
        if (StringUtils.isBlank(username)) {
            return  null;
        }
        return userMapper.findUserByLoginName(username);
    }


    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
