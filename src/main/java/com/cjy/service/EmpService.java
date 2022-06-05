package com.cjy.service;

import com.cjy.domain.Emp;

import java.util.List;

public interface EmpService {

    // 添加员工信息
    void addEmp(Emp emp);

    // 分页查询全部员工信息
    List<Emp> allEmp(Integer page);

    Integer CountEmp();

    // 删除员工信息
    void deleteEmp(Integer id);

    // 根据员工编号查询信息
    Emp findEmpById(Integer id);

    // 根据员工姓名模糊查询员工信息
    List<Emp> findEmpByName(String name);

    Emp findEmpByUsername(String username);

    // 更新员工信息
    void updateEmp(Emp emp);

}
