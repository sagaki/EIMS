package com.cjy.dao;

import com.cjy.domain.Emp;
import com.cjy.domain.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoginDao {

    @Insert("insert into login(username,password,purview,activation) values(#{username},#{password},#{purview},#{activation})")
    Integer addLogin(Emp emp);

    // 通过修改字段值实现假删除 假删除员工信息
    @Update("update login set activation='否' where eid=#{id}")
    Integer deleteLogin(Integer id);

    @Select("select * from login where username=#{username} and password=#{password} and activation='是'")
    Login findLogin(Login login);

    @Update("update login set activation='是' where username=#{username}")
    Integer updateActivation(String username);

    @Update("update login set username=#{username},purview=#{purview} where eid=#{id}")
    Integer updateLogin(Emp emp);

    @Update("update login set password=#{password} where username=#{username}")
    Integer updatePassword(Login login);

}
