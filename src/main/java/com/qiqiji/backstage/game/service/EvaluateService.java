package com.qiqiji.backstage.game.service;

public interface EvaluateService {
    //评价审核（通过评价自增id修改评价状态）
    String updateEvaluate(int evaluation_Review,int evaluate_Id,String refuse_Desc);
}
