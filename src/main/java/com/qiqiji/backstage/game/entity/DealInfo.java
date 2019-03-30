package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

//订单表
@Table(name = "dealinfo")
@Entity
public class DealInfo {
    @Id
    @JsonProperty(value = "dealNo")
    @Column(name = "dealNo")
    private String dealNo;//店家交易流水
    @JsonProperty(value = "chatDealNo")
    @Column(name = "chatDealNo")
    private String chatDealNo;//微信交易流水号
    @JsonProperty(value = "returnCode")
    @Column(name = "returnCode")
    private String returnCode;//支付返回码
    @JsonProperty(value = "returnDesc")
    @Column(name = "returnDesc")
    private String returnDesc;//支付返回描述
    @JsonProperty(value = "sum")
    @Column(name = "sum")
    private String sum;//支付金额
    @JsonProperty(value = "dealState")
    @Column(name = "dealState")
    private String dealState;//支付标志0-支付成功1-支付失败
    @JsonProperty(value = "createUser")
    @Column(name = "createUser")
    private String createUser;//创建人
    @JsonProperty(value = "createTime")
    @Column(name = "createTime")
    private String createTime;//创建时间
    @JsonProperty(value = "updateUser")
    @Column(name = "updateUser")
    private String updateUser;//修改人
    @JsonProperty(value = "updateTime")
    @Column(name = "updateTime")
    private String updateTime;//修改时间
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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

    public String getDealNo() {
        return dealNo;
    }

    public void setDealNo(String dealNo) {
        this.dealNo = dealNo;
    }

    public String getChatDealNo() {
        return chatDealNo;
    }

    public void setChatDealNo(String chatDealNo) {
        this.chatDealNo = chatDealNo;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getDealState() {
        return dealState;
    }

    public void setDealState(String dealState) {
        this.dealState = dealState;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DealInfo{" +
                "dealNo='" + dealNo + '\'' +
                ", chatDealNo='" + chatDealNo + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnDesc='" + returnDesc + '\'' +
                ", sum='" + sum + '\'' +
                ", dealState='" + dealState + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", qqjCode='" + qqjCode + '\'' +
                ", qqjDesc='" + qqjDesc + '\'' +
                ", pageSize=" + pageSize +
                ", page='" + page + '\'' +
                ", count=" + count +
                ", totalPage=" + totalPage +
                '}';
    }
}
