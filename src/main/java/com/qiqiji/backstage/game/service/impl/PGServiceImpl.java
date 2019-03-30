package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.repository.PlayGroupRepository;
import com.qiqiji.backstage.game.service.PlayGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PGServiceImpl implements PlayGroupService{
    @Autowired
    private PlayGroupRepository playGroupRepository;

    @Override
    public List<Object[]> getPlayGroupByGroupFull(int page, int pageSize) {
        List<Object[]> GroupFullList = playGroupRepository.getPlayGroupByGroupFull(page,pageSize);
        return GroupFullList;
    }

    @Override
    public List<Object[]> getPlayGroupByGroupNotFull(int page, int pageSize) {
        List<Object[]> GroupNotFullList = playGroupRepository.getPlayGroupByGroupNotFull(page,pageSize);
        return GroupNotFullList;
    }

    @Override
    public List<Object[]> getPlayGroupByNeedReturnFee(int page, int pageSize) {
        List<Object[]> NeedReturnFeeList = playGroupRepository.getPlayGroupByNeedReturnFee(page,pageSize);
        return NeedReturnFeeList;
    }

    @Override
    public List<Object[]> getPlayGroupByEffective(int page, int pageSize) {
        List<Object[]> EffectiveList = playGroupRepository.getPlayGroupByEffective(page,pageSize);
        return EffectiveList;
    }

    @Override
    public List<Object[]> getPlayGroupByHistory(int page, int pageSize, Date queryDate) {
        List<Object[]> HistoryList = playGroupRepository.getPlayGroupByHistory(page,pageSize,queryDate);
        return HistoryList;
    }

    @Override
    public int getGroupFullCount() {
        int count = playGroupRepository.getGroupFullCount();
        return count;
    }

    @Override
    public int getGroupNotFullCount() {
        int count = playGroupRepository.getGroupNotFullCount();
        return count;
    }

    @Override
    public int getNeedReturnFeeCount() {
        int count = playGroupRepository.getNeedReturnFeeCount();
        return count;
    }

    @Override
    public int getEffectiveCount() {
        int count = playGroupRepository.getEffectiveCount();
        return count;
    }

    @Override
    public int getHistoryCount(Date queryDate) {
        int count = playGroupRepository.getHistoryCount(queryDate);
        return count;
    }

}
