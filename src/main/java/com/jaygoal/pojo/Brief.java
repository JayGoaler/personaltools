package com.jaygoal.pojo;

public class Brief{
    /**
     * 案由名称
     */
    private String briefType;
    /**
     * 件数
     */
    private Integer briefNumber;
    /**
     * 占律师申请异地阅卷总数的**%
     */
    private Double persentOfBriefNumber;
    /**
     * 同比（上升/下降）**%
     */
    private Double persentOfBriefNumberUpOrDown;

    public Brief(String briefType, Integer briefNumber, Double persentOfBriefNumber, Double persentOfBriefNumberUpOrDown) {
        this.briefType = briefType;
        this.briefNumber = briefNumber;
        this.persentOfBriefNumber = persentOfBriefNumber;
        this.persentOfBriefNumberUpOrDown = persentOfBriefNumberUpOrDown;
    }

    public String getBriefType() {
        return briefType;
    }

    public void setBriefType(String briefType) {
        this.briefType = briefType;
    }

    public Integer getBriefNumber() {
        return briefNumber;
    }

    public void setBriefNumber(Integer briefNumber) {
        this.briefNumber = briefNumber;
    }

    public Double getPersentOfBriefNumber() {
        return persentOfBriefNumber;
    }

    public void setPersentOfBriefNumber(Double persentOfBriefNumber) {
        this.persentOfBriefNumber = persentOfBriefNumber;
    }

    public Double getPersentOfBriefNumberUpOrDown() {
        return persentOfBriefNumberUpOrDown;
    }

    public void setPersentOfBriefNumberUpOrDown(Double persentOfBriefNumberUpOrDown) {
        this.persentOfBriefNumberUpOrDown = persentOfBriefNumberUpOrDown;
    }
}
