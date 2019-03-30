package com.qiqiji.backstage.game.service;

import com.qiqiji.backstage.game.entity.Scenario;

public interface ScenarioService {
    //新增剧本
    String saveScenario(Scenario scenario);
    //删除剧本
    String deleteScenarioById(int scenarioId);
}
