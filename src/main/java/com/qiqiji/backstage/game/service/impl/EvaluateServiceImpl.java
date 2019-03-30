package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.repository.EvaluateRepository;
import com.qiqiji.backstage.game.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateServiceImpl implements EvaluateService{

    @Autowired
    private EvaluateRepository evaluateRepository;
    @Override
    public String updateEvaluate (int evaluation_Review, int evaluate_Id,String refuse_Desc) {
        evaluateRepository.updateEvaluate(evaluation_Review,evaluate_Id,refuse_Desc);
        return null;
    }
}
