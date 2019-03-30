package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EvaluateRepository extends JpaRepository<Evaluate,Integer> {
    //审核评价
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE evaluate SET evaluation_Review = ?1 ,refuse_Desc = ?3 WHERE evaluate_Id = ?2",nativeQuery = true)
    void updateEvaluate(int evaluation_Review,int evaluate_Id,String refuse_Desc);




}
