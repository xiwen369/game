package com.qiqiji.backstage.game.service;

import com.qiqiji.backstage.game.entity.CodeInfo;

import java.util.List;

public interface CodeInfoService {
    //查询游戏配置
    List<CodeInfo> getCodeInfoByType();
    //查询关于我们信息
    List<CodeInfo> getCodeInfoAboutUs();
    //关于我们修改接口
    String updateAboutUs(String code_Desc);
}
