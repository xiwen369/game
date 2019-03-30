package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser,Integer> {
    @Query(value = "select lp.password from loginuser lp where lp.username=?1",nativeQuery = true)
    String logining(String username);
}
