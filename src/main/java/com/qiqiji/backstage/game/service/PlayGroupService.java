package com.qiqiji.backstage.game.service;

import java.util.Date;
import java.util.List;

public interface PlayGroupService{
    //0-组满预约完成
    List<Object[]> getPlayGroupByGroupFull(int page, int pageSize);
    //1-未满预约中
    List<Object[]> getPlayGroupByGroupNotFull(int page, int pageSize);
    //2-人未满失效，待退费
    List<Object[]> getPlayGroupByNeedReturnFee(int page, int pageSize);
    //4-所有的有效组局
    List<Object[]> getPlayGroupByEffective(int page, int pageSize);
    //5-历史对局
    List<Object[]> getPlayGroupByHistory(int page, int pageSize, Date queryDate);

    //0-组满预约完成的总条数
    int getGroupFullCount();
    //1-未满预约中的总条数
    int getGroupNotFullCount();
    //2-人未满失效，待退费的总条数
    int getNeedReturnFeeCount();
    //4-所有的有效组局的总条数
    int getEffectiveCount();
    //5-历史对局的总条数
    int getHistoryCount(Date queryDate);


}
