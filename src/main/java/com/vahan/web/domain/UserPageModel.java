package com.vahan.web.domain;

import javax.validation.constraints.Size;

/**
 * Created by vahan on 3/25/17.
 */
public class UserPageModel {

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
