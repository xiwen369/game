package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.entity.DealInfo;
import com.qiqiji.backstage.game.service.DealInfoService;
import com.qiqiji.backstage.game.tool.GetTotalPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "订单查询接口")
@RestController
public class DealInfoController {
    @Autowired
    private DealInfoService dealInfoService;
    //访问http://localhost:port/swagger-ui.html   测试使用
    //http://localhost:9003/test/hello?name=111
    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/getDealInfo", method= RequestMethod.POST)
    public List<DealInfo> getDealInfo(@RequestBody Map<String,String> map){
        System.out.println(map);
        int page = Integer.parseInt(map.get("page"));//页数
        int pageSize = Integer.parseInt(map.get("pageSize"));//页大小
        System.out.println(page);
        int count = 0;//总条数
        int totalPage = 0;//总页数
        Map<String,Integer> pageMap = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//字符串转日期
        String flag = (String) map.get("flag");
        Date queryDate = null;
        if("2".equals(flag)){
            String time = (String) map.get("queryDate");
            System.out.println("xw时间"+time);
            queryDate = Date.valueOf(time);
            System.out.println("xw日期"+queryDate);
        }
        List<DealInfo> dealInfoList = null;
        if ("1".equals(flag)) {
            //当天订单
            pageMap = queryCount(pageSize,flag,queryDate);
            page =getPage(page,pageSize,flag,queryDate);
            dealInfoList = dealInfoService.getDealInfoBycurdate(page,pageSize);
        } else if ("2".equals(flag)) {
            //指定日期订单
            pageMap = queryCount(pageSize,flag,queryDate);
            page =getPage(page,pageSize,flag,queryDate);
            dealInfoList = dealInfoService.getDealInfoBySpecifyDat(page,pageSize,queryDate);
        } else if ("3".equals(flag)) {
            //需要退费的订单
            pageMap = queryCount(pageSize,flag,queryDate);
            page =getPage(page,pageSize,flag,queryDate);
            dealInfoList = dealInfoService.getDealInfoByRefund(page,pageSize);
        }
        if(dealInfoList==null){
            dealInfoList = new ArrayList();
            DealInfo dealInfo = new DealInfo();
            dealInfo.setQqjCode("0001");
            dealInfo.setQqjDesc("查询订单异常");
            dealInfoList.add(dealInfo);
            return dealInfoList;
        }else if (dealInfoList.size()==0){
            DealInfo dealInfo = new DealInfo();
            dealInfo.setQqjCode("0002");
            dealInfo.setQqjDesc("查询订单为空！");
            dealInfoList.add(dealInfo);
            return dealInfoList;
        }
        count = pageMap.get("count");
        totalPage = pageMap.get("totalPage");
        dealInfoList.get(0).setCount(count);
        dealInfoList.get(0).setTotalPage(totalPage);
        System.out.println(dealInfoList.get(0).toString());
        return dealInfoList;
    }
    //获取订单列表的总条数和总页数
    public Map queryCount(int pageSize,String flag,Date queryDate){
        Map<String,Integer> map = new HashMap();
        int count = 0;
        int totalPage = 0;
        if("1".equals(flag)){
            //当天订单总条数
            count = dealInfoService.getCurdateCount();
            totalPage = getTotalPage(pageSize,count);
        }else if("2".equals(flag)){
            //指定日期订单总条数
            count = dealInfoService.getspecifyDatCount(queryDate);
            totalPage = getTotalPage(pageSize,count);

        }else if("3".equals(flag)){
            //待退费订单总条数
            count = dealInfoService.getRefundCount();
            totalPage = getTotalPage(pageSize,count);
        }
        map.put("count", count);
        map.put("totalPage", totalPage);
        return map;
    }
    //获取订单列表的总页数
    public int getTotalPage(int pageSize, int count){
        GetTotalPage gtp = new GetTotalPage();
        int totalPage = gtp.getTotalPage(pageSize,count);
//        int totalPage = 0;
//        int totalCount = Integer.valueOf(count);
//        if("0".equals(totalCount)){
//            return totalPage;
//        }
//        totalPage = totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize +1 ;
//        if(totalPage<1){
//            totalPage = 1;
//        }
        return totalPage;
    }
    //页数判断
    public int getPage(int page, int pageSize,String flag,Date queryDate){
        Map<String,Integer> pageMap = null;
        pageMap = queryCount(pageSize,flag,queryDate);
        int tPage = pageMap.get("totalPage");
        if (page>tPage){
            page = (tPage - 1) * pageSize;
        }else if(page==0){
            page = 0;
        }else{
            page = page * pageSize;
        }
        return page;
    }
}
