package com.laowang.entity;

/**
 * @author 隔壁老王
 */
public class User {
    private Integer uid;
    private String name;
    private String phone;
    private Integer age;
    private Integer sex; //性别 0、男 1、女
    private String username;
    private String password;
    private Integer status = 1; //状态 1、启用 2、禁用
    private String createTime;
    private Integer role; //用户角色 1、管理员 2、一般用户 3、vip
    private String picture;

    public User() {
    }

    public User(Integer uid, String name, String phone, Integer age, Integer sex, String username, String password, Integer status, String createTime, Integer role, String picture) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.status = status;
        this.createTime = createTime;
        this.role = role;
        this.picture = picture;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
