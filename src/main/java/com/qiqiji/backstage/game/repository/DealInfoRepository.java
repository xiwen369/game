package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.DealInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//订单查询
@Repository
public interface DealInfoRepository extends JpaRepository<DealInfo,Integer> {
    //查询当天的订单
    @Query(value = "SELECT * FROM dealinfo di WHERE date(di.create_Time) = curdate() LIMIT ?1,?2",nativeQuery = true)
    List<DealInfo> getDealInfoBycurdate(int page, int pageSize);
    //查询指定日期的订单
    @Query(value = "SELECT\n" +
            "\tdi.deal_No,\n" +
            "\tdi.chat_Deal_No,\n" +
            "\tdi.return_Code ,\n" +
            "\tdi.return_Desc,\n" +
            "\tdi.`sum`,\n" +
            "\tdi.deal_State,\n" +
            "\tdi.create_User,\n" +
            "\tdi.create_Time,\n" +
            "\tdi.update_User,\n" +
            "\tdi.update_Time\n" +
            "FROM\n" +
            "\tdealinfo di\n" +
            "WHERE\n" +
            "\tdate (di.create_Time) = ?3 limit ?1,?2",nativeQuery = true)
    List<DealInfo> getDealInfoBySpecifyDat(int page,int pageSize,Date queryDate);
    //查询查询需要退费的订单
    @Query(value = "SELECT di.deal_No,di.chat_Deal_No,di.return_Code,di.return_Desc,di.`sum`,di.deal_State,di.create_User,di.create_Time,di.update_User,di.update_Time\n" +
            "FROM playgroup pg,dealinfo di,play_user pu WHERE pg.play_Id = pu.play_Id\n" +
            "AND di.deal_No = pu.deal_No AND pg.start_Flag = '2' AND di.deal_State = '1'",nativeQuery = true)
    List<DealInfo> getDealInfoByRefund();

    //查询当天订单的总条数
    @Query(value = "SELECT COUNT(*) FROM  dealinfo di WHERE date(di.create_Time) = curdate()",nativeQuery = true)
    int getCurdateCount();

    //查询指定日期订单的总条数
    @Query(value = "SELECT COUNT(*) FROM  dealinfo di WHERE date(di.create_Time) = ?1",nativeQuery = true)
    int getspecifyDatCount(Date queryDate);

    //查询需要退费订单的总条数
    @Query(value = "SELECT COUNT(*) FROM playgroup pg,dealinfo di,play_user pu WHERE pg.play_Id = pu.play_Id AND di.deal_No = pu.deal_No AND pg.start_Flag = '2' AND di.deal_State = '1'",nativeQuery = true)
    int getRefundCount();

}
