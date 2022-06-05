package com.cjy.dao;

import com.cjy.domain.Emp;
import com.cjy.domain.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoginDao {

    // 添加员工登录信息
    @Insert("insert into login(username,password,purview,activation) values(#{username},#{password},#{purview},#{activation})")
    Integer addLogin(Emp emp);

    // 通过修改字段值实现假删除 假删除员工信息
    @Update("update login set activation='否' where eid=#{id}")
    Integer deleteLogin(Integer id);

    // 登录查询
    @Select("select * from login where username=#{username} and password=#{password} and activation='是'")
    Login findLogin(Login login);

    // 激活员工账号
    @Update("update login set activation='是' where username=#{username}")
    Integer updateActivation(String username);

    // 修改员工登录信息
    @Update("update login set username=#{username},purview=#{purview} where eid=#{id}")
    Integer updateLogin(Emp emp);

    // 修改员工登录密码
    @Update("update login set password=#{password} where username=#{username}")
    Integer updatePassword(Login login);

}
