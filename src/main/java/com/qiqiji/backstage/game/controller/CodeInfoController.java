package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.entity.CodeInfo;
import com.qiqiji.backstage.game.service.CodeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(description = "游戏配置接口")
@RestController
public class CodeInfoController {
    @Autowired
    CodeInfoService codeInfoService;
    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/GameSetting", method= RequestMethod.POST)
    public List<CodeInfo> GameSetting(){
        List<CodeInfo> codeInfoList = codeInfoService.getCodeInfoByType();
        System.out.println(codeInfoList.size());
        if(codeInfoList==null){
            CodeInfo codeInfo = new CodeInfo();
            codeInfo.setQqjCode("0001");
            codeInfo.setQqjDesc("查询游戏设置异常！");
            codeInfoList.add(codeInfo);
            return codeInfoList;
        }else if(codeInfoList.size()==0){
            CodeInfo codeInfo = new CodeInfo();
            codeInfo.setQqjCode("0002");
            codeInfo.setQqjDesc("查询游戏设置为空！");
            codeInfoList.add(codeInfo);
            return codeInfoList;
        }
        return codeInfoList;
    }

    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/abortUsQuery", method= RequestMethod.POST)
    public List<CodeInfo> abortUsQuery(){
        List<CodeInfo> codeInfoList = codeInfoService.getCodeInfoAboutUs();
        return codeInfoList;
    }

    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/aboutUsUpdate", method= RequestMethod.POST)
    public String aboutUsUpdate(@RequestBody Map map){
        String code_Desc = (String) map.get("code_Desc");
        codeInfoService.updateAboutUs(code_Desc);
        return "0000";
    }
}
