package com.turing.service.impl;

import com.turing.entity.Attributes;
import com.turing.entity.SysMenus;
import com.turing.mapper.SysMenusMapper;
import com.turing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SysMenusMapper sysMenusMapper;

    /**
     * 查找所有菜单
     * @return 所有菜单集合
     */
    @Override
    public List<SysMenus> findAllMenus() {
        List<SysMenus> allMenus = sysMenusMapper.selectByExample(null);

        List<SysMenus> fatherMenus = findFatherMenus(allMenus);
        return fatherMenus;
    }

    /**
     * 查找所有父菜单
     * @param allMenus 所有菜单集合
     * @return 返回父菜单集合
     */
    private List<SysMenus> findFatherMenus(List<SysMenus> allMenus) {
        //创建一个父菜单集合
        List<SysMenus> fatherMenus = new ArrayList<>();
        //遍历所有菜单
        allMenus.forEach(menu ->{
            //判断parentId是否为零（根节点）
            if(menu.getParentId() == 0){
                //设置根节点的子节点
                menu.setChildren(findChildrenMenu(menu.getId(),allMenus));
                //添加父菜单到父菜单集合中
                fatherMenus.add(menu);
            }
        });
        return fatherMenus;
    }

    /**
     * 查找所有子菜单
     * @param id 父菜单id
     * @param allMenus 所有菜单
     * @return 返回所有子菜单集合
     */
    private List<SysMenus> findChildrenMenu(Integer id, List<SysMenus> allMenus) {
        //创建一个子菜单集合
        List<SysMenus> childrenMenus = new ArrayList<>();
        //遍历所有菜单
        allMenus.forEach(menu ->{
            //判断是否是子节点
            if(menu.getParentId() == id){
                //添加url、icon
                Attributes attributes = new Attributes();
                attributes.setUrl(menu.getLinkUrl());
                attributes.setIcon(menu.getImageUrl());
                menu.setAttributes(attributes);
                //递归处理（查找该子菜单下的子菜单）
                menu.setChildren(findChildrenMenu(menu.getId(), allMenus));
                //把子菜单添加至子菜单集合
                childrenMenus.add(menu);
            }
        });
        //返回子菜单
        return childrenMenus;
    }
}
