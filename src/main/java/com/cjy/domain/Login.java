package com.cjy.domain;

/**
 * 登录信息持久化类
 */
public class Login {

    private String activation;  // 是否删除标识
    private Integer eid;        // 主键ID
    private String password;    // 登录用密码
    private String purview;     // 员工权限
    private String username;    // 登录用户名

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPurview() {
        return purview;
    }

    public void setPurview(String purview) {
        this.purview = purview;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
