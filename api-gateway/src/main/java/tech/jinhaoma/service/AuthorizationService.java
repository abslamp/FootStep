package tech.jinhaoma.service;

import tech.jinhaoma.domain.LoginResponse;

/**
 * Created by mjrt on 2/20/2017.
 */

public interface AuthorizationService {
    LoginResponse login(String name , String passWord);
    boolean logOut(String token);
    boolean authorize(String token);
}
