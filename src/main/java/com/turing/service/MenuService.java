package com.turing.service;

import com.turing.entity.SysMenus;

import java.util.List;

public interface MenuService {
    //查询全部菜单
    List<SysMenus> findAllMenus();
}
