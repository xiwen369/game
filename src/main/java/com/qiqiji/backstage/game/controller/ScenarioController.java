package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.entity.Scenario;
import com.qiqiji.backstage.game.service.ScenarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Api(description = "剧本增删改接口")
@RestController
public class ScenarioController {
    @Autowired
    private ScenarioService scenarioService;
    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/AddPlay", method= RequestMethod.POST)
    public String AddPlay(@RequestBody Scenario scenario){
        System.out.println(scenario);
        //进行持久化操作
        try {
            scenarioService.saveScenario(scenario);
            return "0000";
        }catch (Exception e){
            e.printStackTrace();
            return "0001";
        }
    }

    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/DeletePlay", method= RequestMethod.POST)
    public String DeletePlay(@RequestBody HashMap<String,String> map){
        System.out.println(map);
        int scenarioId = Integer.valueOf(map.get("scenarioId"));
        try {
            scenarioService.deleteScenarioById(scenarioId);
            return "0000";
        }catch (Exception e){
            e.printStackTrace();
            return "0001";
        }
    }
}
