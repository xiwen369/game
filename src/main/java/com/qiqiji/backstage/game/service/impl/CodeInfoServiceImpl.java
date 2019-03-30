package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.entity.CodeInfo;
import com.qiqiji.backstage.game.repository.CodeInfoRepository;
import com.qiqiji.backstage.game.service.CodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeInfoServiceImpl implements CodeInfoService{
    @Autowired
    private CodeInfoRepository codeInfoRepository;

    @Override
    public List<CodeInfo> getCodeInfoByType() {
        //查询游戏配置
        List<CodeInfo> codeInfoList = codeInfoRepository.getCodeInfo();
        return codeInfoList;
    }

    @Override
    public List<CodeInfo> getCodeInfoAboutUs() {
        //查询关于我们信息
        List<CodeInfo> codeInfoAboutUsList = codeInfoRepository.getCodeInfoAboutUs();
        return codeInfoAboutUsList;
    }

    @Override
    public String updateAboutUs(String code_Desc) {
        codeInfoRepository.updateAboutUs(code_Desc);
        return null;
    }
}
