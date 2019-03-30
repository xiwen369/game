package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.CodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//游戏配置
@Repository
public interface CodeInfoRepository extends JpaRepository<CodeInfo,Integer>{
    //查询游戏配置
    @Query(value = "SELECT code_Type,code_Desc,code_Context FROM codeinfo WHERE code_Type = 'A009'",nativeQuery = true)
    List<CodeInfo> getCodeInfo();
    //查询关于我们信息
    @Query(value = "SELECT code_Type,code_Desc,code_Context FROM codeinfo WHERE code_Type = 'A010'",nativeQuery = true)
    List<CodeInfo> getCodeInfoAboutUs();
    //修改关于我们信息
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE codeinfo SET code_Desc = ?1 WHERE code_type = 'A010'",nativeQuery = true)
    void updateAboutUs(String code_Desc);

}
