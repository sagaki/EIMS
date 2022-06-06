package com.service;

import com.domain.Login;

public interface LoginService {

    // 登录查询
    Login findLogin(Login login);

    // 激活员工账号
    Integer updateActivation(String username);

    // 修改员工登录密码
    Integer updatePassword(Login login);

}
