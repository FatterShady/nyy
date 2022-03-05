package com.nyy.boot.service;

import com.nyy.boot.bean.User;
import com.nyy.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WxrStart
 * @create 2022-03-04 21:41
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
       return userMapper.getAllUser();
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }


    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUser(Integer userId) {
        userMapper.deleteUserByPrimaryKey(userId);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public User login(User user) {
       return  userMapper.getUserByUserName(user.getUsername());
    }

    public User regist(User user) {
        return userMapper.getUserByUserName(user.getUsername());
    }

    public void reigstUser(User user) {
        userMapper.addUser(user);
    }
}
