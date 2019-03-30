package com.qiqiji.backstage.game.repository;

import com.qiqiji.backstage.game.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//会员查询
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //查询所有会员
    @Query(value = "SELECT * FROM user limit ?1,?2",nativeQuery = true)
    List<User> getUserByAll(int page, int pageSize);
    //按会员号查询会员信息
    @Query(value = "SELECT * FROM user WHERE user_id = ?1",nativeQuery = true)
    List<User> getUserByMemberNo(int user_id);
    //按会员号删除会员信息
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM user WHERE user_id = ?1",nativeQuery = true)
    void deleteUserByMemberNo(int user_id);

    //查询所有会员
    @Query(value = "SELECT COUNT(*) FROM user",nativeQuery = true)
    int getAllUserCount();


}
