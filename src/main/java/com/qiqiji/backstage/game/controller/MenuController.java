package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.entity.Menu;
import com.qiqiji.backstage.game.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "餐品信息增删改接口")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/AddMenu", method= RequestMethod.POST)
    public String AddMenu(@RequestParam Menu menu){
        System.out.println(menu.toString());
        //进行持久化操作
        try {
            menuService.saveMenu(menu);
            return "0000";
        }catch (Exception e){
            e.printStackTrace();
            return "0001";
        }
    }

}
