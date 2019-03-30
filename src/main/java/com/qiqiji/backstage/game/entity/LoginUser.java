package com.qiqiji.backstage.game.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loginuser")
public class LoginUser {
    @Id
    @Column(name = "username")
    private  String  username;
    @Column(name = "password")
    private  String password;

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
