package com.qiqiji.backstage.game.service;

import com.qiqiji.backstage.game.entity.User;

import java.util.List;

public interface UserService {
    //查询所有的会员信息
    List<User> getUserByAll(int page, int pageSize);
    //通过会员号精确查询
    List<User> getUserByMemberNo(int memberNo);
    //通过会员号删除会员信息
    String deleteUserByMemberNo(int memberNo);
    //通过会员号修改会员信息
    String saveMemberNo(User user);

    //查询所有的会员信息总条数
    int getAllUserCount();

}
