package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(description = "评价审核接口")
@RestController
public class EvaluateController {
    @Autowired
    EvaluateService evaluateService;
    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/evaluateCheck", method= RequestMethod.POST)
    public String evaluateCheck(@RequestBody Map map){
        int evaluate_Id = Integer.parseInt((String) map.get("evaluate_Id"));
        int evaluation_Review = Integer.parseInt((String) map.get("evaluation_Review"));//1-审核失败  2-审核通过
        String refuse_Desc = (String) map.get("refuse_Desc");//拒绝描述
        try {
            evaluateService.updateEvaluate(evaluate_Id,evaluation_Review,refuse_Desc);
            return "0000";
        }catch (Exception e){
            e.printStackTrace();
            return "0001";
        }
    }
}
