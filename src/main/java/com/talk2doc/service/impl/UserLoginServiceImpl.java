package com.talk2doc.service.impl;

import com.talk2doc.entity.UserLoginEntity;
import com.talk2doc.model.UserLogin;
import com.talk2doc.repository.UserLoginRepository;
import com.talk2doc.service.UserLoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserLoginRepository loginRepository;

    public UserLoginServiceImpl(@Autowired UserLoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserLogin validateUserLogin(UserLogin login) {
        UserLoginEntity loginEntity = loginRepository.findByMobileNo(login.getMobileNo());
        if(loginEntity != null ) {
            if(login.getPw_pin().equals(loginEntity.getPw_pin())) {
                BeanUtils.copyProperties(loginEntity, login);
            } else
                return null;
        } else
            return null;
        System.out.println("User Login Detail: " + login);
        return login;
    }

    @Override
    public UserLogin addUserLogin(UserLogin login) {
        UserLoginEntity loginEntity = new UserLoginEntity();
        BeanUtils.copyProperties(login, loginEntity);
        loginEntity = loginRepository.save(loginEntity);
        return login;
    }
}
