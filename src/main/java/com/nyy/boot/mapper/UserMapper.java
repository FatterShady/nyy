package com.nyy.boot.mapper;

import com.nyy.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author WxrStart
 * @create 2022-03-04 21:42
 */
@Mapper
public interface UserMapper {

    List<User> getAllUser();


    User getUserById(Integer id);

    User getUserByUserName(String username);

    void updateByPrimaryKeySelective(User user);

    void deleteUserByPrimaryKey(Integer userId);

    void addUser(User user);

    User queryUserIfExist(User user);
}
