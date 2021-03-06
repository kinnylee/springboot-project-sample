package com.kinnylee.entity;

import com.kinnylee.enums.Province;
import com.kinnylee.enums.Sex;
import com.kinnylee.enums.UserStatus;

public class User {
    private Integer id;

    private String name;

    private Sex sex;

    private Province province;

    private UserStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}