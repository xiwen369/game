package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.PlayGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//组局查询
@Repository
public interface PlayGroupRepository extends JpaRepository<PlayGroup,Integer> {
    //0-组满预约完成
    @Query(value = "SELECT pg.play_Id,sa.scenario_Name,sa.play_People,SUM((select count(1) from playgroup pp where pp.play_Id=pg.play_Id)) join_People,pg.create_time\n" +
            "FROM playgroup pg,scenario sa,play_user pu\n" +
            "where pg.play_Id=pu.play_Id\n" +
            "and  pg.scenario_Id=sa.scenario_Id and pg.start_flag = '0' \n" +
            "GROUP BY(pg.play_Id) limit ?1,?2",nativeQuery = true)
    List<Object[]> getPlayGroupByGroupFull(int page, int pageSize);
    //1-未满预约中
    @Query(value = "SELECT pg.play_Id,sa.scenario_Name,sa.play_People,SUM((select count(1) from playgroup pp where pp.play_Id=pg.play_Id)) join_People,pg.create_time\n" +
            "FROM playgroup pg,scenario sa,play_user pu\n" +
            "where pg.play_Id=pu.play_Id\n" +
            "and  pg.scenario_Id=sa.scenario_Id and pg.start_flag = '1' \n" +
            "GROUP BY(pg.play_Id) limit ?1,?2",nativeQuery = true)
    List<Object[]> getPlayGroupByGroupNotFull(int page, int pageSize);
    //2-人未满失效，待退费
    @Query(value = "SELECT pg.play_Id,sa.scenario_Name,sa.play_People,SUM((select count(1) from playgroup pp where pp.play_Id=pg.play_Id)) join_People,pg.create_time\n" +
            "FROM playgroup pg,scenario sa,play_user pu\n" +
            "where pg.play_Id=pu.play_Id\n" +
            "and  pg.scenario_Id=sa.scenario_Id and pg.start_flag = '2' \n" +
            "GROUP BY(pg.play_Id) limit ?1,?2",nativeQuery = true)
    List<Object[]> getPlayGroupByNeedReturnFee(int page, int pageSize);
    //4-所有的有效组局
    @Query(value = "SELECT pg.play_Id,sa.scenario_Name,sa.play_People,SUM((select count(1) from playgroup pp where pp.play_Id=pg.play_Id)) join_People,pg.create_time\n" +
            "FROM playgroup pg,scenario sa,play_user pu\n" +
            "where pg.play_Id=pu.play_Id\n" +
            "and  pg.scenario_Id=sa.scenario_Id and pg.start_flag <> '0' \n" +
            "GROUP BY(pg.play_Id) limit ?1,?2",nativeQuery = true)
    List<Object[]> getPlayGroupByEffective(int page, int pageSize);
    //5-历史对局
    @Query(value = "SELECT pg.play_Id,sa.scenario_Name,sa.play_People,SUM((select count(1) from playgroup pp where pp.play_Id=pg.play_Id)) join_People,pg.create_time\n" +
            "FROM playgroup pg,scenario sa,play_user pu\n" +
            "where pg.play_Id=pu.play_Id\n" +
            "and  pg.scenario_Id=sa.scenario_Id and date(pg.create_Time) = ?3 \n" +
            "GROUP BY(pg.play_Id) limit ?1,?2",nativeQuery = true)
    List<Object[]> getPlayGroupByHistory(int page, int pageSize, Date queryDate);

    //查询0-组满预约完成总条数
    @Query(value = "SELECT COUNT(*) FROM (SELECT count(1)\n" +
            "             FROM playgroup pg,scenario sa,play_user pu\n" +
            "             where pg.play_Id=pu.play_Id\n" +
            "             and  pg.scenario_Id=sa.scenario_Id and pg.start_flag = '0'\n" +
            "             GROUP BY(pg.play_Id)) AS a",nativeQuery = true)
    int getGroupFullCount();
    //1-未满预约中的总条数
    @Query(value = "SELECT COUNT(*) FROM (SELECT count(1)\n" +
            "             FROM playgroup pg,scenario sa,play_user pu\n" +
            "             where pg.play_Id=pu.play_Id\n" +
            "             and  pg.scenario_Id=sa.scenario_Id and pg.start_flag = '1'\n" +
            "             GROUP BY(pg.play_Id)) AS a",nativeQuery = true)
    int getGroupNotFullCount();
    //2-人未满失效，待退费的总条数
    @Query(value = "SELECT COUNT(*) FROM (SELECT count(1)\n" +
            "             FROM playgroup pg,scenario sa,play_user pu\n" +
            "             where pg.play_Id=pu.play_Id\n" +
            "             and  pg.scenario_Id=sa.scenario_Id and pg.start_flag = '2'\n" +
            "             GROUP BY(pg.play_Id)) AS a",nativeQuery = true)
    int getNeedReturnFeeCount();
    //4-所有的有效组局的总条数
    @Query(value = "SELECT COUNT(*) FROM (SELECT count(1)\n" +
            "             FROM playgroup pg,scenario sa,play_user pu\n" +
            "             where pg.play_Id=pu.play_Id\n" +
            "             and  pg.scenario_Id=sa.scenario_Id and pg.start_flag <> '2'\n" +
            "             GROUP BY(pg.play_Id)) AS a",nativeQuery = true)
    int getEffectiveCount();
    //5-历史对局的总条数
    @Query(value = "SELECT COUNT(*) FROM (SELECT count(1)\n" +
            "             FROM playgroup pg,scenario sa,play_user pu\n" +
            "             where pg.play_Id=pu.play_Id\n" +
            "             and  pg.scenario_Id=sa.scenario_Id and date(pg.create_Time) = ?1 \n" +
            "             GROUP BY(pg.play_Id)) AS a",nativeQuery = true)
    int getHistoryCount(Date queryDate);

}
