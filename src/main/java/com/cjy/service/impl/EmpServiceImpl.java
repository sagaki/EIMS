package com.cjy.service.impl;

import com.cjy.dao.EmpDao;
import com.cjy.dao.LoginDao;
import com.cjy.domain.Emp;
import com.cjy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    // 注解注入EmpDao
    @Autowired
    private EmpDao empDao;

    // 注解注入LoginDao
    @Autowired
    private LoginDao loginDao;

    // 添加员工信息
    @Override
    public void addEmp(Emp emp) {
        this.empDao.addEmp(emp);
        emp.setEid(this.empDao.count());
        this.loginDao.addLogin(emp);
    }

    // 分页查询全部员工信息
    @Override
    public List<Emp> allEmp(Integer paeg) {
        return this.empDao.allEmp(paeg);
    }

    // 查询总页数
    @Override
    public Integer countEmp() {
        return this.empDao.countEmp();
    }

    // 删除员工信息
    @Override
    public void deleteEmp(Integer id) {
        this.loginDao.deleteLogin(id);
    }

    // 根据员工编号查询信息
    @Override
    public Emp findEmpById(Integer id) {
        return this.empDao.findEmpById(id);
    }

    // 根据员工姓名模糊查询员工信息
    @Override
    public List<Emp> findEmpByName(String name) {
        return this.empDao.findEmpByName(name);
    }

    // 根据员工登录用户名查询员工信息
    @Override
    public Emp findEmpByUsername(String username) {
        return this.empDao.findEmpByUsername(username);
    }

    // 更新员工信息
    @Override
    public void updateEmp(Emp emp) {
        this.empDao.updateEmp(emp);
        this.loginDao.updateLogin(emp);
    }

}
