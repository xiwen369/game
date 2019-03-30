package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.entity.Scenario;
import com.qiqiji.backstage.game.repository.ScenarioRepository;
import com.qiqiji.backstage.game.service.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//新增剧本接口
@Service
public class ScenarioServiceImpl implements ScenarioService {
    @Autowired
    private ScenarioRepository scenarioRepository;

    @Override
    public String saveScenario(Scenario scenario) {
        scenarioRepository.save(scenario);
        return null;
    }

    @Override
    public String deleteScenarioById(int scenarioId) {
        Scenario scenario = new Scenario();
        scenario.setScenarioId(scenarioId);
        System.out.println("对象"+scenario);
        scenarioRepository.deleteScenarioById(scenarioId);
        return "0000";
    }
}
