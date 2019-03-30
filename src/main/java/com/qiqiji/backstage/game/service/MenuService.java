package com.qiqiji.backstage.game.service;

import com.qiqiji.backstage.game.entity.Menu;

public interface MenuService {
    //插入(修改)餐品信息
    String saveMenu(Menu menu);
    //删除餐品信息
    String deleteMenu(int menu_Id);

}
