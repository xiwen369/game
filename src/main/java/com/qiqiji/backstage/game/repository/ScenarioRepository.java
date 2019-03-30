package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario,Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value=" delete from scenario where scenario_Id =?1",nativeQuery = true)
    void deleteScenarioById(int scenarioId);
}
