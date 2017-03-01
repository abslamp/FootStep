package tech.jinhaoma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jinhaoma.domain.LoginResponse;
import tech.jinhaoma.service.AuthorizationService;

/**
 * Created by mjrt on 2/20/2017.
 */
@RestController
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    @PostMapping(value = "/login")
    public LoginResponse login(String userName , String passWord){
        LoginResponse res = service.login(userName,passWord);
        System.out.println(res.getToken());
        return res;
//        return service.login(userName,passWord);
    }

    @RequestMapping(value = "/auth")
    public boolean AuthTest(String token){
        System.out.println(token);
        return service.authorize(token);
    }




}
