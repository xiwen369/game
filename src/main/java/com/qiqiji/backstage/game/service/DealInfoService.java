package com.qiqiji.backstage.game.service;

import com.qiqiji.backstage.game.entity.DealInfo;

import java.util.Date;
import java.util.List;

public interface DealInfoService {
    List<DealInfo> getDealInfoById(DealInfo dealInfo);

    //查询当天的订单
    List<DealInfo> getDealInfoBycurdate(int page,int pageSize);
    //查询指定日期的订单
    List<DealInfo> getDealInfoBySpecifyDat(int page,int pageSize,Date queryDate);
    //查询需要退费的订单
    List<DealInfo> getDealInfoByRefund(int page,int pageSize);

    //查询当天订单总条数
    int getCurdateCount();
    //查询指定日期订单总条数
    int getspecifyDatCount(Date queryDate);
    //查询需要退费的订单总条数
    int getRefundCount();
}
