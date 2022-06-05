package com.cjy.service;

import com.cjy.domain.Login;

public interface LoginService {

    Login findLogin(Login login);

    Integer updateActivation(String username);

    Integer updatePassword(Login login);

}
