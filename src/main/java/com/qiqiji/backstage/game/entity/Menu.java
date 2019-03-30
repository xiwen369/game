package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "menu")
@Entity
public class Menu {
    @Id
    @JsonProperty (value = "menuId")
    @Column (name = "menuId")
    private int menuId;
    @JsonProperty (value = "name")
    @Column (name = "name")
    private String name;
    @JsonProperty (value = "menuDescribe")
    @Column (name = "menuDescribe")
    private String menuDescribe;
    @JsonProperty (value = "price")
    @Column (name = "price")
    private String price;
    @JsonProperty (value = "storeId")
    @Column (name = "storeId")
    private Integer storeId;//店铺ID
    @JsonProperty (value = "menuUrl")
    @Column (name = "menuUrl")
    private  String menuUrl;
    @JsonProperty(value = "qqjCode")
    @Transient
    private  String qqjCode;
    @JsonProperty(value = "qqjDesc")
    @Transient
    private  String qqjDesc;

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

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return menuDescribe;
    }

    public void setDescribe(String describe) {
        this.menuDescribe = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", name='" + name + '\'' +
                ", menuDescribe='" + menuDescribe + '\'' +
                ", price='" + price + '\'' +
                ", storeId=" + storeId +
                ", menuUrl='" + menuUrl + '\'' +
                ", qqjCode='" + qqjCode + '\'' +
                ", qqjDesc='" + qqjDesc + '\'' +
                '}';
    }
}
