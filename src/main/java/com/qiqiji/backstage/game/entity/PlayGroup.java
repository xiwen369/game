package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

//组局表
@Table(name = "playgroup")
@Entity
public class PlayGroup{
    @Id
    @JsonProperty(value = "playId")
    @Column(name = "playId")
    private int playId;
    @JsonProperty(value = "scenarioId")
    @Column(name = "scenarioId")
    private String scenarioId;//剧本ID
    @JsonProperty(value = "storeId")
    @Column(name = "storeId")
    private String storeId;//店铺ID
    @JsonProperty(value = "startTime")
    @Column(name = "startTime")
    private String startTime;//开局时间
    @JsonProperty(value = "startFlag")
    @Column(name = "startFlag")
    private String startFlag;
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

    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }
}
