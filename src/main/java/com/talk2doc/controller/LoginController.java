package com.talk2doc.controller;

import com.talk2doc.model.UserLogin;
import com.talk2doc.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/talk2doc/")
public class LoginController {

    private final UserLoginService userLoginService;

    public LoginController(@Autowired UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> talk2DocLogin (@RequestBody UserLogin login) {
        UserLogin loginResp = userLoginService.validateUserLogin(login);
        if(loginResp == null)
            return new ResponseEntity<>("Invalid credential for mobile no : " + login.getMobileNo(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(loginResp, HttpStatus.OK);

    }
}
