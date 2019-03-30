package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

//码值表
@Table(name = "user")
@Entity
public class User {
    @Id
    @JsonProperty(value = "userId")
    @Column(name = "userId")
    private int userId;//会员号码自增

    @JsonProperty(value = "openId")
    @Column(name = "openId")
    private String openId;//微信id

    @JsonProperty(value = "groId")
    @Column(name = "gro_Id")
    private String gro_Id;

    @JsonProperty(value = "userName")
    @Column(name = "userName")
    private String userName;//会员名称

    @JsonProperty(value = "phoneNumber")
    @Column(name = "phoneNumber")
    private int phoneNumber;//会员手机号

    @JsonProperty(value = "integral")
    @Column(name = "integral")
    private int integral;//会员积分
    @JsonProperty(value = "qqjCode")
    @Transient
    private  String qqjCode;
    @JsonProperty(value = "qqjDesc")
    @Transient
    private  String qqjDesc;

    @JsonProperty(value = "pageSize")
    @Transient
    private  int pageSize;
    @JsonProperty(value = "page")
    @Transient
    private  String page;
    @JsonProperty(value = "count")
    @Transient
    private  int count;
    @JsonProperty(value = "totalPage")
    @Transient
    private  int totalPage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getGro_Id() {
        return gro_Id;
    }

    public void setGro_Id(String gro_Id) {
        this.gro_Id = gro_Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getQqjCode() {
        return qqjCode;
    }

    public void setQqjCode(String qqjCode) {
        this.qqjCode = qqjCode;
    }

    public String getQqjDesc() {
        return qqjDesc;
    }

    public void setQqjDesc(String qqjDesc) {
        this.qqjDesc = qqjDesc;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
