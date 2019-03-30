package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

//剧本表
@Table(name = "scenario")
@Entity
public class Scenario {
    @Id
    @JsonProperty(value = "scenarioId")
    @Column(name = "scenarioId")
    private int scenarioId;

    @JsonProperty(value = "scenarioName")
    @Column(name = "scenarioName")
    private String scenarioName;

    @JsonProperty(value = "imageUrl")
    @Column(name = "imageUrl")
    private String imageUrl;

    @JsonProperty(value = "scenarioDesc")
    @Column(name = "scenarioDesc")
    private String scenarioDesc;

    @JsonProperty(value = "playPeople")
    @Column(name = "playPeople")
    private String playPeople;

    @JsonProperty(value = "scenarioTime")
    @Column(name = "scenarioTime")
    private int scenarioTime;

    @JsonProperty(value = "playType")
    @Column(name = "playType")
    private String playType;

    @JsonProperty(value = "author")
    @Column(name = "author")
    private String author;

    @JsonProperty(value = "storeId")
    @Column(name = "storeId")
    private int storeId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescribe() {
        return scenarioDesc;
    }

    public void setDescribe(String describe) {
        this.scenarioDesc = describe;
    }

    public String getPalyPeople() {
        return playPeople;
    }

    public void setPalyPeople(String palyPeople) {
        this.playPeople = palyPeople;
    }

    public int getScenariodTime() {
        return scenarioTime;
    }

    public void setScenariodTime(int scenariodTime) {
        this.scenarioTime = scenariodTime;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "scenarioId=" + scenarioId +
                ", scenarioName='" + scenarioName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", describe='" + scenarioDesc + '\'' +
                ", palyPeople='" + playPeople + '\'' +
                ", scenariodTime=" + scenarioTime +
                ", playType='" + playType + '\'' +
                ", author='" + author + '\'' +
                ", storeId=" + storeId +
                '}';
    }
}
