package com.nyy.boot.controller;

import com.nyy.boot.bean.Msg;
import com.nyy.boot.bean.User;
import com.nyy.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WxrStart
 * @create 2022-03-04 21:46
 */
@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有的用户
     * @return
     */
    @GetMapping
    @ResponseBody
    public Msg getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return Msg.success().add("user",allUsers);
    }

    /**
     * 根据id查询一个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Msg getUserById(@PathVariable Integer id){
        User userById = userService.getUserById(id);
        return Msg.success().add("user",userById);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping
    @ResponseBody
    public Msg updateEmp(@RequestBody User user){
        userService.updateUser(user);
        return Msg.success();

    }


    /**
     * 根据id删除用户信息
     * @param userId
     * @return
     */
    @ResponseBody
    @DeleteMapping(value = "/{userId}")
    public Msg deleteEmp(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return Msg.success();
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping
    public Msg addUser(@RequestBody User user){
        userService.addUser(user);
        return Msg.success();
    }

}
