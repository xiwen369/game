package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {



}
