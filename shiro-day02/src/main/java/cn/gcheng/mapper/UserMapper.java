package cn.gcheng.mapper;

import cn.gcheng.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author gcheng.L
 * @create 2019-04-11 15:32
 */
@Repository
public interface UserMapper {

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    User findUserByLoginName(@Param("username") String username);
}
