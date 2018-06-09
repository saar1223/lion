package com.steven.lion.core.entity;

import java.io.Serializable;

/**
 * 项目名称:com.steven.lion.core.entity
 * 类名称:User
 * 描述:
 * 创建人:steven
 * 创建时间:2018-06-09 19:29
 */
public class User implements Serializable{
    private String username;
    private String password;

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
}
