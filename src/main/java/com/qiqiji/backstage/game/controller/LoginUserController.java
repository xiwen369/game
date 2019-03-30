package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.service.LoginUserService;
import com.qiqiji.backstage.game.tool.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "后台login")
@RestController
public class LoginUserController {
    @Autowired
    LoginUserService loginUserService;
    @ApiOperation(value = "后台登录" ,  notes="后台登录")
    @RequestMapping(value = "/loginUserProving", method = POST)
    @ResponseBody
    public Map<String,String>  loginUserProving(@RequestBody Map<String,String> map){
        Map<String, String> map2login = new HashMap<>();
        String username = map.get("username");
        String password = map.get("password");
        if(username == null || "".equals("username")){
            map2login.put("qqjCode","0001");
            map2login.put("qqjDesc","用户名不能为空");
            return map2login;
        }
        if(password == null || "".equals(password)){
            map2login.put("qqjCode","0001");
            map2login.put("qqjDesc","密码不能为空");
            return map2login;
        }
        String dbPwd = loginUserService.logining(username);
        if(dbPwd == null || "".equals(dbPwd)){
            map2login.put("qqjCode","0001");
            map2login.put("qqjDesc","不存在当前用户");
            return  map2login;
        }
        if(MD5Utils.passwordIsTure(password,dbPwd)){
            map2login.put("qqjCode","0000");
            map2login.put("qqjDesc","登陆成功");
        }else{
            map2login.put("qqjCode","0001");
            map2login.put("qqjDesc","账号密码错误");
        }
        return map2login;
    }
}
