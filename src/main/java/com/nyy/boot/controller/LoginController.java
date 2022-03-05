package com.nyy.boot.controller;

import com.nyy.boot.bean.Msg;
import com.nyy.boot.bean.User;
import com.nyy.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author WxrStart
 * @create 2022-03-05 13:56
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Msg login(@RequestBody User user,HttpServletRequest request) {
        User login = userService.login(user);
        if (login == null) {
            return Msg.fail().add("errorMsg", "用户名无效");
        }
         else if (!login.getPassword().equals(user.getPassword())) {
            return Msg.fail().add("errorMsg", "密码错误");
        }else {
            request.getSession().setAttribute("user",login);
            return Msg.success();
        }
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public Msg regist(@RequestBody User user) {
        User regist = userService.regist(user);
        if(regist!=null){
            return Msg.fail().add("errorMsg","用户已存在请直接登录");
        }else {
            userService.reigstUser(user);
            return Msg.success();
        }
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";


    }



}
