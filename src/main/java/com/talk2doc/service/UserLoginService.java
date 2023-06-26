package com.talk2doc.service;

import com.talk2doc.model.UserLogin;
import org.springframework.stereotype.Component;

@Component
public interface UserLoginService {
    UserLogin validateUserLogin(UserLogin login);

    UserLogin addUserLogin(UserLogin login);
}
