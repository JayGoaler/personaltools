package com.jaygoal.pojo;

public class Case{
    /**
     * 案件类型
     */
    private String caseType;
    /**
     * 件数
     */
    private Integer caseTypeNumber;
    /**
     * 占律师申请异地阅卷总数的**%
     */
    private Double persentOfCaseTypeNumber;
    /**
     * 同比（上升/下降）**%
     */
    private Double persentOfCaseTypeNumberUpOrDown;

    public Case(String caseType, Integer caseTypeNumber, Double persentOfCaseTypeNumber, Double persentOfCaseTypeNumberUpOrDown) {
        this.caseType = caseType;
        this.caseTypeNumber = caseTypeNumber;
        this.persentOfCaseTypeNumber = persentOfCaseTypeNumber;
        this.persentOfCaseTypeNumberUpOrDown = persentOfCaseTypeNumberUpOrDown;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Integer getCaseTypeNumber() {
        return caseTypeNumber;
    }

    public void setCaseTypeNumber(Integer caseTypeNumber) {
        this.caseTypeNumber = caseTypeNumber;
    }

    public Double getPersentOfCaseTypeNumber() {
        return persentOfCaseTypeNumber;
    }

    public void setPersentOfCaseTypeNumber(Double persentOfCaseTypeNumber) {
        this.persentOfCaseTypeNumber = persentOfCaseTypeNumber;
    }

    public Double getPersentOfCaseTypeNumberUpOrDown() {
        return persentOfCaseTypeNumberUpOrDown;
    }

    public void setPersentOfCaseTypeNumberUpOrDown(Double persentOfCaseTypeNumberUpOrDown) {
        this.persentOfCaseTypeNumberUpOrDown = persentOfCaseTypeNumberUpOrDown;
    }
}
