package com.cjy.service;

import com.cjy.domain.Emp;

import java.util.List;

public interface EmpService {

    void addEmp(Emp emp);

    // 分页查询全部员工信息
    List<Emp> allEmp(Integer page);

    Integer CountEmp();

    void deleteEmp(Integer id);

    Emp findEmpById(Integer id);

    List<Emp> findEmpByName(String name);

    Emp findEmpByUsername(String username);

    void updateEmp(Emp emp);

}
