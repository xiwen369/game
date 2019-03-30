package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

//码值表
@Table(name = "codeinfo")
@Entity
public class CodeInfo {
    @Id
    @JsonProperty(value = "codeType")
    @Column(name = "codeType")
    private String codeType;//类型
    @JsonProperty(value = "codeDesc")
    @Column(name = "codeDesc")
    private String codeDesc;//游戏类型
    @JsonProperty(value = "codeContext")
    @Column(name = "codeContext")
    private String codeContext;//游戏类型码值
    @JsonProperty(value = "qqjCode")
    @Transient
    private  String qqjCode;
    @JsonProperty(value = "qqjDesc")
    @Transient
    private  String qqjDesc;

    public String getQqjCode(String s) {
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

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public String getCodeContext() {
        return codeContext;
    }

    public void setCodeContext(String codeContext) {
        this.codeContext = codeContext;
    }
}
