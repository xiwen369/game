package com.qiqiji.backstage.game.service.impl;

import com.qiqiji.backstage.game.repository.LoginUserRepository;
import com.qiqiji.backstage.game.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    LoginUserRepository loginUserRepository;
    @Override
    public String logining(String username) {
        return loginUserRepository.logining(username);
    }
}
