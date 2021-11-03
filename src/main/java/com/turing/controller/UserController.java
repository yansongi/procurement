package com.turing.controller;

import com.turing.entity.SysUsers;
import com.turing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param sysUsers 用户对象
     * @return 跳转页面
     */
    @PostMapping("/login")
    public String login(SysUsers sysUsers){
        boolean b = userService.login(sysUsers);
        if(b){
            return "redirect:/index.html";
        }else{
            return "redirect:/login.html";
        }
    }
}
