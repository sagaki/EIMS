package com.cjy.service.impl;

import com.cjy.dao.LoginDao;
import com.cjy.domain.Login;
import com.cjy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public Login findLogin(Login login) {
        return this.loginDao.findLogin(login);
    }

    @Override
    public Integer updateActivation(String username) {
        return this.loginDao.updateActivation(username);
    }

    @Override
    public Integer updatePassword(Login login) {
        return this.loginDao.updatePassword(login);
    }

}
