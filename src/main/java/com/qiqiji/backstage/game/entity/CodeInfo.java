package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

//码值表
@Table(name = "codeinfo")
@Entity
@Data
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
}
