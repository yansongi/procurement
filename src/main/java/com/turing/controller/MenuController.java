package com.turing.controller;

import com.turing.entity.SysMenus;
import com.turing.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * 菜单控制器
 */
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 查询全部菜单
     * @return
     */
    @GetMapping("/findAllMenus")
    public List<SysMenus> findAllMenus(){
        return menuService.findAllMenus();
    }
}
