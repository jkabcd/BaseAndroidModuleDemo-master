package com.wss.common.bean;

import com.wss.common.base.bean.BaseBean;

import lombok.Getter;
import lombok.Setter;

/**
 * Describe：用户信息
 * Created by 吴天强 on 2018/11/13.
 */
@Setter
@Getter
public class User extends BaseBean {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * email : banshengcy@163.com
     * icon :
     * id : 1260
     * password : *******
     * token :
     * type : 0
     * username : 于慢慢家的吴蜀黍
     */

    private int id;
    private String username;
    private String email;
    private String icon;
    private String password;
    private String token;
    private int type;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
