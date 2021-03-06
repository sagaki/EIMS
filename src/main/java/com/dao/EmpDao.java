package com.dao;

import com.domain.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Emp接口文件
 */
public interface EmpDao {

    // 添加员工信息
    @Insert("insert into emp(name,phone,email) values(#{name},#{phone},#{email})")
    public Integer addEmp(Emp emp);

    // 分页查询全部员工信息 屏蔽被假删除的数据
    @Select("select * from emp,login where id=eid and activation='是' LIMIT #{page},5")
    public List<Emp> allEmp(Integer page);

    // 查询总页数
    @Select("select COUNT(*) from emp,login where id=eid and activation='是'")
    public Integer countEmp();

    // 返回emp.id
    @Select("select COUNT(*) from emp")
    public Integer count();

    // 根据员工编号查询信息
    @Select("select * from emp,login where id=eid and id=#{id} and activation='是'")
    public Emp findEmpById(Integer id);

    // 根据员工姓名模糊查询员工信息
    @Select("select * from emp,login where id=eid and name like concat('%',#{value},'%') and activation='是'")
    public List<Emp> findEmpByName(String name);

    // 根据员工登录用户名查询员工信息
    @Select("select * from emp,login where id=eid and username=#{username}")
    public Emp findEmpByUsername(String username);

    // 更新员工信息
    @Update("update emp set name=#{name},phone=#{phone},email=#{email} where id=#{id}")
    public Integer updateEmp(Emp emp);

}
