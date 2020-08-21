package com.jaygoal.pojo;

public class City{
    /**
     * 城市名
     */
    private String cityName;
    /**
     * 工作数量
     */
    private Integer caseNumber;
    /**
     * 百分比
     */
    private Double persentCaseNumber;

    public City(String cityName, Integer caseNumber, Double persentCaseNumber) {
        this.cityName = cityName;
        this.caseNumber = caseNumber;
        this.persentCaseNumber = persentCaseNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Integer caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Double getPersentCaseNumber() {
        return persentCaseNumber;
    }

    public void setPersentCaseNumber(Double persentCaseNumber) {
        this.persentCaseNumber = persentCaseNumber;
    }
}
