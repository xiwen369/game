package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.service.PlayGroupService;
import com.qiqiji.backstage.game.tool.GetTotalPage;
import com.qiqiji.backstage.game.tool.PackJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "组局查询接口")
@RestController
public class PlayGroupController {
    @Autowired
    private PlayGroupService playGroupService;

    @ApiOperation(value = "调用测试", notes = "调用测试")
    @RequestMapping(value = "/GameTeamQuery", method = RequestMethod.POST)
    public String GameTeamQuery(@RequestBody Map<String, String> map) {
        System.out.println(map);
        int page = Integer.parseInt(map.get("page"));//页数
        int pageSize = Integer.parseInt(map.get("pageSize"));//页大小
        int count = 0;//总条数
        int totalPage = 0;//总页数
        Map<String, Integer> pageMap = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//字符串转日期
        String flag = map.get("flag");
        Date queryDate = null;
        if ("5".equals(flag)) {
            String time = (String) map.get("queryDate");
            System.out.println("xw时间" + time);
            queryDate = Date.valueOf(time);
            System.out.println("xw日期" + queryDate);
        }
        List<Object[]> playGroupList = null;
        if ("0".equals(flag)) {
            try {
                pageMap = queryCount(pageSize, flag, queryDate);
                page = getPage(page, pageSize, flag, queryDate);
                playGroupList = playGroupService.getPlayGroupByGroupFull(page, pageSize);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("1".equals(flag)) {
            pageMap = queryCount(pageSize, flag, queryDate);
            page = getPage(page, pageSize, flag, queryDate);
            playGroupList = playGroupService.getPlayGroupByGroupNotFull(page, pageSize);
        } else if ("2".equals(flag)) {
            pageMap = queryCount(pageSize, flag, queryDate);
            page = getPage(page, pageSize, flag, queryDate);
            playGroupList = playGroupService.getPlayGroupByNeedReturnFee(page, pageSize);
        } else if ("4".equals(flag)) {
            pageMap = queryCount(pageSize, flag, queryDate);
            page = getPage(page, pageSize, flag, queryDate);
            playGroupList = playGroupService.getPlayGroupByEffective(page, pageSize);
        } else if ("5".equals(flag)) {
            pageMap = queryCount(pageSize, flag, queryDate);
            page = getPage(page, pageSize, flag, queryDate);
            playGroupList = playGroupService.getPlayGroupByHistory(page, pageSize, queryDate);
        }
        count = pageMap.get("count");
        totalPage = pageMap.get("totalPage");
        String stringJson = PackJson.packJson(playGroupList,count,totalPage);
        return stringJson;
    }

    //获取组局的总条数和总页数
    public Map queryCount(int pageSize, String flag, Date queryDate) {
        Map<String, Integer> map = new HashMap();
        int count = 0;
        int totalPage = 0;
        if ("0".equals(flag)) {
            //0-组满预约完成的总条数
            count = playGroupService.getGroupFullCount();
            totalPage = GetTotalPage.getTotalPage(pageSize, count);
        } else if ("1".equals(flag)) {
            //1-未满预约中的总条数
            count = playGroupService.getGroupNotFullCount();
            totalPage = GetTotalPage.getTotalPage(pageSize, count);
        } else if ("2".equals(flag)) {
            //2-人未满失效，待退费的总条数
            count = playGroupService.getNeedReturnFeeCount();
            totalPage = GetTotalPage.getTotalPage(pageSize, count);
        } else if ("4".equals(flag)) {
            //4-所有的有效组局的总条数
            count = playGroupService.getEffectiveCount();
            totalPage = GetTotalPage.getTotalPage(pageSize, count);
        } else if ("5".equals(flag)) {
            //5-历史对局的总条数
            count = playGroupService.getHistoryCount(queryDate);
            totalPage = GetTotalPage.getTotalPage(pageSize, count);
        }
        map.put("count", count);
        map.put("totalPage", totalPage);
        return map;
    }

    //页数判断
    public int getPage(int page, int pageSize, String flag, java.sql.Date queryDate) {
        Map<String, Integer> pageMap = null;
        pageMap = queryCount(pageSize, flag, queryDate);
        int tPage = pageMap.get("totalPage");
        if (page > tPage) {
            page = (tPage - 1) * pageSize;
        } else if (page == 0) {
            page = 0;
        } else {
            page = page * pageSize;
        }
        return page;
    }
}
