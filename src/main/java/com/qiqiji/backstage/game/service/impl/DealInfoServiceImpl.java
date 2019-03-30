package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.entity.DealInfo;
import com.qiqiji.backstage.game.repository.DealInfoRepository;
import com.qiqiji.backstage.game.service.DealInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DealInfoServiceImpl implements DealInfoService {

    @Autowired
    private DealInfoRepository dealInfoRepository;
    @Override
    public List<DealInfo>  getDealInfoById(DealInfo dealInfo) {
       // List<DealInfo> dInfo = dealInfoRepository.getDealInfoById();
        List<DealInfo> dInfo = dealInfoRepository.findAll();
        return dInfo;
    }
    //查询当天的订单
    public List<DealInfo>  getDealInfoBycurdate(int page,int pageSize) {
        List<DealInfo> dInfo = dealInfoRepository.getDealInfoBycurdate(page,pageSize);
        return dInfo;
    }
    //查询指定日期的订单
    public List<DealInfo>  getDealInfoBySpecifyDat(int page,int pageSize,Date queryDate) {
        List<DealInfo> dInfo = dealInfoRepository.getDealInfoBySpecifyDat(page,pageSize,queryDate);
        return dInfo;
    }
    //查询需要退费的订单
    public List<DealInfo>  getDealInfoByRefund(int page,int pageSize) {
        List<DealInfo> dInfo = dealInfoRepository.getDealInfoByRefund();
        return dInfo;
    }

    @Override
    public int getCurdateCount() {
        int count = dealInfoRepository.getCurdateCount();
        return count;
    }

    @Override
    public int getspecifyDatCount(Date queryDate) {
        int count = dealInfoRepository.getspecifyDatCount(queryDate);
        return count;
    }

    @Override
    public int getRefundCount() {
        int count = dealInfoRepository.getRefundCount();
        return count;
    }

}
