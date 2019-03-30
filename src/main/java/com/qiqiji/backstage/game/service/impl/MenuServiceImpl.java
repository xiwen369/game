package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.entity.Menu;
import com.qiqiji.backstage.game.repository.MenuRepository;
import com.qiqiji.backstage.game.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;
    @Override
    public String saveMenu(Menu menu) {
        menuRepository.save(menu);
        return null;
    }

    @Override
    public String deleteMenu(int menu_Id) {
        return null;
    }
}
