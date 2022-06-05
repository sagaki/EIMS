package com.cjy.dao;

import com.cjy.domain.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Emp接口文件
 */
public interface EmpDao {

    @Insert("insert into emp(name,phone,email) values(#{name},#{phone},#{email})")
	Integer addEmp(Emp emp);

    // 分页查询全部员工信息
    @Select("select * from emp,login where id=eid and activation='是' LIMIT #{page},5")
	List<Emp> allEmp(Integer page);

    @Select("select COUNT(*)/5 from emp,login where id=eid and activation='是'")
	Integer CountEmp();

    @Select("select * from emp,login where id=eid and id=#{id} and activation='是'")
	Emp findEmpById(Integer id);

    @Select("select * from emp,login where id=eid and name like concat('%',#{value},'%') and activation='是'")
	List<Emp> findEmpByName(String name);

    @Select("select * from emp,login where id=eid and username=#{username}")
	Emp findEmpByUsername(String username);

    @Update("update emp set name=#{name},phone=#{phone},email=#{email} where id=#{id}")
	Integer updateEmp(Emp emp);

}
