package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.entity.User;
import com.qiqiji.backstage.game.repository.UserRepository;
import com.qiqiji.backstage.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getUserByAll(int page, int pageSize) {
        List<User> userAllList = userRepository.getUserByAll(page,pageSize);
        return userAllList;
    }

    @Override
    public List<User> getUserByMemberNo(int memberNo) {
        List<User> userPartList = userRepository.getUserByMemberNo(memberNo);
        return userPartList;
    }

    @Override
    public String deleteUserByMemberNo(int memberNo) {
        User user = new User();
        user.setUserId(memberNo);
        System.out.println("对象"+user);
        userRepository.deleteUserByMemberNo(memberNo);
        return "0000";
    }

    @Override
    public String saveMemberNo(User user) {
        userRepository.save(user);
        return null;
    }

    @Override
    public int getAllUserCount() {
        int count = userRepository.getAllUserCount();
        return count;
    }

}
