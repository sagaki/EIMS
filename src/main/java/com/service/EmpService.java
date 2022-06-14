package com.service;

import com.domain.Emp;

import java.util.List;

public interface EmpService {

    // 添加员工信息
    public void addEmp(Emp emp);

    // 分页查询全部员工信息
    public List<Emp> allEmp(Integer page);

    // 查询总页数
    public Integer countEmp();

    // 删除员工信息
    public void deleteEmp(Integer id);

    // 根据员工编号查询信息
    public Emp findEmpById(Integer id);

    // 根据员工姓名模糊查询员工信息
    public List<Emp> findEmpByName(String name);

    // 根据员工登录用户名查询员工信息
    public Emp findEmpByUsername(String username);

    // 更新员工信息
    public void updateEmp(Emp emp);

}
