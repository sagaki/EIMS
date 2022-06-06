package com.service.impl;

import com.dao.LoginDao;
import com.domain.Login;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    // 注解注入LoginDao
    @Autowired
    private LoginDao loginDao;

    // 登录查询
    @Override
    public Login findLogin(Login login) {
        return this.loginDao.findLogin(login);
    }

    // 激活员工账号
    @Override
    public Integer updateActivation(String username) {
        return this.loginDao.updateActivation(username);
    }

    // 修改员工登录密码
    @Override
    public Integer updatePassword(Login login) {
        return this.loginDao.updatePassword(login);
    }

}
