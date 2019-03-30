package com.qiqiji.backstage.game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "evaluate")
@Entity
public class Evaluate {
    @Id
    @JsonProperty(value = "evaluateId")
    @Column(name = "evaluateId")
    private Integer evaluateId;
    @JsonProperty(value = "evaluationDistinction")
    @Column(name = "evaluationDistinction")
    private Integer evaluationDistinction;//评价区分，0剧本评价，1餐品评价
    @JsonProperty(value = "userId")
    @Column(name = "userId")
    private Integer userId;
    @JsonProperty(value = "evaluationContent")
    @Column(name = "evaluationContent")
    private String evaluationContent;//评价内容
    @JsonProperty(value = "evaluationReview")
    @Column(name = "evaluationReview")
    private Integer evaluationReview;//评价审核，0待审核，1审核失败，2审核通过
    @JsonProperty(value = "evaluationgrade")
    @Column(name = "evaluationgrade")
    private Integer evaluationgrade;//评价等级，0好评，1中评，2差评
    @JsonProperty(value = "relationId")
    @Column(name = "relationId")
    private Integer relationId;//关联id
    @JsonProperty(value = "refuseDesc")
    @Column(name = "refuseDesc")
    private String refuseDesc;//拒绝描述
    @JsonProperty(value = "storeId")
    @Column(name = "storeId")
    private  int sotreId;//店铺id
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

    public int getSotreId() {
        return sotreId;
    }

    public void setSotreId(int sotreId) {
        this.sotreId = sotreId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getEvaluationDistinction() {
        return evaluationDistinction;
    }

    public void setEvaluationDistinction(Integer evaluationDistinction) {
        this.evaluationDistinction = evaluationDistinction;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public Integer getEvaluationReview() {
        return evaluationReview;
    }

    public void setEvaluationReview(Integer evaluationReview) {
        this.evaluationReview = evaluationReview;
    }

    public Integer getEvaluationgrade() {
        return evaluationgrade;
    }

    public void setEvaluationgrade(Integer evaluationgrade) {
        this.evaluationgrade = evaluationgrade;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getRefuseDesc() {
        return refuseDesc;
    }

    public void setRefuseDesc(String refuseDesc) {
        this.refuseDesc = refuseDesc;
    }

}
