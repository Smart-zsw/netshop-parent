package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.manager.mapper.SysMenuMapper;
import com.zsw.netshop.manager.service.SysMenuService;
import com.zsw.netshop.manager.utils.MenuHelper;
import com.zsw.netshop.model.entity.system.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    //菜单列表
    @Override
    public List<SysMenu> findNodes() {
        //1 查询所有菜单，返回list集合
        List<SysMenu> sysMenuList = sysMenuMapper.findAll();
        if (CollectionUtils.isEmpty(sysMenuList)) {
            return null;
        }

        //2 调用工具类的方法，把返回list集合封装要求数据格式
        return MenuHelper.buildTree(sysMenuList);
    }
}
