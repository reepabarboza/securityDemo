package com.reepa.domain;

import javax.persistence.Entity;

/**
 * Created by pradeep on 14-06-2016.
 */
@Entity
public class User {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
