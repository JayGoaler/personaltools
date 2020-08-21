package com.jaygoal.pojo;

import java.util.List;

/**
 * @program: jlpt
 * @description: 报告数据输入类
 * @author: JayGoal
 * @create: 2020-08-07 15:40
 **/
public class ReportInputDto {
    /**
     * 单位名称
     */
    private String depName;

    /**
     * 起始年份后两位
     */
    private Integer startYear;
    /**
     * 起始月份
     */
    private Integer startMonth;

    /**
     * 结束年份后两位
     */
    private Integer endYear;
    /**
     * 结束月份
     */
    private Integer endMonth;
    /**
     * 受理律师异地阅卷申请人次
     */
    private Integer countNumberOfApplicants;
    /**
     * 受理律师异地阅卷申请人次同比上升、下降比例
     */
    private Double persentOfApplicants;
    /**
     * 成功办理律师异地阅卷业务数量
     */
    private Integer countNumberOfReviewDossier;
    /**
     * 成功办理律师异地阅卷业务占总业务百分比
     */
    private Double persentOfReviewDossier;
    /**
     * 成功办理律师异地阅卷业务占总业务百分比同比上升或者下降
     */
    private Double persentOfReviewDossierUpOrDown;
    /**
     * 平均办理时长
     */
    private Double dayOfHandleTime;
    /**
     * 平均办理时长缩短天数
     */
    private Double dayOfHandleTimeLessThanLastYear;

    private Integer totalNumbersOfMatter;

    private Integer totalNumbersOfLayerMatter;

    /**
     * 市名
     */
    private String baseCityName;
    /**
     * 区名
     */
    private String baseAreaName;
    /**
     * 合作市、区数量
     */
    private Integer numberOfCooperationArea;
    /**
     * 合作单位数量
     */
    private Integer numberOfCooperationDepartment;
    /**
     * 成功办理数量
     */
    private Integer numberOfSuccessfullyHandled;
    /**
     * 占业务总量百分比
     */
    private Double persentNumberOfTotal;

    /**
     * 异地阅卷申请人次
     */
    private Integer applicantTimes;
    /**
     * 同比上升、下降比例
     */
    private Double persentOfApplicantTimes;
    /**
     * 不予受理人次
     */
    private Integer rejectedApplicants;
    /**
     * 成功办理业务人次
     */
    private Integer successfullyHandled;
    /**
     * 同比上升、下降比例
     */
    private Double persentOfSuccessfullyHandled;

    /**
     * 平局办理时长
     */
    private Double averageDuration;
    /**
     * 缩短天数
     */
    private Double averageDurationLessThanLastYear;
    /**
     * 退回原因
     */
    private String reasonForReturn;
    /**
     * 退回人次
     */
    private Integer reasonForReturnTimes;

    /**
     * 一、2段的案件信息循环
     */
    private List<Case> caseTypeList;
    /**
     * 一、3的工作数量较高地区循环
     */
    private List<City> workNumberList;
    /**
     * 一、	开展律师异地阅卷工作基本情况、3段的案由类型循环
     */
    private List<Brief> briefList;

    public ReportInputDto(String depName, Integer startYear, Integer startMonth, Integer endYear, Integer endMonth, Integer countNumberOfApplicants, Double persentOfApplicants, Integer countNumberOfReviewDossier, Double persentOfReviewDossier,
                          Double persentOfReviewDossierUpOrDown, Double dayOfHandleTime, Double dayOfHandleTimeLessThanLastYear, String baseCityName, String baseAreaName, Integer numberOfCooperationArea, Integer numberOfCooperationDepartment,
                          Integer numberOfSuccessfullyHandled, Double persentNumberOfTotal, Integer applicantTimes, Double persentOfApplicantTimes, Integer rejectedApplicants, Integer successfullyHandled, Double persentOfSuccessfullyHandled,
                          Double averageDuration, Double averageDurationLessThanLastYear, String reasonForReturn, Integer reasonForReturnTimes,Integer totalNumbersOfMatter,Integer totalNumbersOfLayerMatter) {
        this.depName = depName;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.countNumberOfApplicants = countNumberOfApplicants;
        this.persentOfApplicants = persentOfApplicants;
        this.countNumberOfReviewDossier = countNumberOfReviewDossier;
        this.persentOfReviewDossier = persentOfReviewDossier;
        this.persentOfReviewDossierUpOrDown = persentOfReviewDossierUpOrDown;
        this.dayOfHandleTime = dayOfHandleTime;
        this.dayOfHandleTimeLessThanLastYear = dayOfHandleTimeLessThanLastYear;
        this.baseCityName = baseCityName;
        this.baseAreaName = baseAreaName;
        this.numberOfCooperationArea = numberOfCooperationArea;
        this.numberOfCooperationDepartment = numberOfCooperationDepartment;
        this.numberOfSuccessfullyHandled = numberOfSuccessfullyHandled;
        this.persentNumberOfTotal = persentNumberOfTotal;
        this.applicantTimes = applicantTimes;
        this.persentOfApplicantTimes = persentOfApplicantTimes;
        this.rejectedApplicants = rejectedApplicants;
        this.successfullyHandled = successfullyHandled;
        this.persentOfSuccessfullyHandled = persentOfSuccessfullyHandled;
        this.averageDuration = averageDuration;
        this.averageDurationLessThanLastYear = averageDurationLessThanLastYear;
        this.reasonForReturn = reasonForReturn;
        this.reasonForReturnTimes = reasonForReturnTimes;
        this.totalNumbersOfMatter = totalNumbersOfMatter;
        this.totalNumbersOfLayerMatter = totalNumbersOfLayerMatter;
    }

    public Integer getTotalNumbersOfMatter() {
        return totalNumbersOfMatter;
    }

    public void setTotalNumbersOfMatter(Integer totalNumbersOfMatter) {
        this.totalNumbersOfMatter = totalNumbersOfMatter;
    }

    public Integer getTotalNumbersOfLayerMatter() {
        return totalNumbersOfLayerMatter;
    }

    public void setTotalNumbersOfLayerMatter(Integer totalNumbersOfLayerMatter) {
        this.totalNumbersOfLayerMatter = totalNumbersOfLayerMatter;
    }

    public ReportInputDto() {
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public Integer getCountNumberOfApplicants() {
        return countNumberOfApplicants;
    }

    public void setCountNumberOfApplicants(Integer countNumberOfApplicants) {
        this.countNumberOfApplicants = countNumberOfApplicants;
    }

    public Double getPersentOfApplicants() {
        return persentOfApplicants;
    }

    public void setPersentOfApplicants(Double persentOfApplicants) {
        this.persentOfApplicants = persentOfApplicants;
    }

    public Integer getCountNumberOfReviewDossier() {
        return countNumberOfReviewDossier;
    }

    public void setCountNumberOfReviewDossier(Integer countNumberOfReviewDossier) {
        this.countNumberOfReviewDossier = countNumberOfReviewDossier;
    }

    public Double getPersentOfReviewDossier() {
        return persentOfReviewDossier;
    }

    public void setPersentOfReviewDossier(Double persentOfReviewDossier) {
        this.persentOfReviewDossier = persentOfReviewDossier;
    }

    public Double getPersentOfReviewDossierUpOrDown() {
        return persentOfReviewDossierUpOrDown;
    }

    public void setPersentOfReviewDossierUpOrDown(Double persentOfReviewDossierUpOrDown) {
        this.persentOfReviewDossierUpOrDown = persentOfReviewDossierUpOrDown;
    }

    public Double getDayOfHandleTime() {
        return dayOfHandleTime;
    }

    public void setDayOfHandleTime(Double dayOfHandleTime) {
        this.dayOfHandleTime = dayOfHandleTime;
    }

    public Double getDayOfHandleTimeLessThanLastYear() {
        return dayOfHandleTimeLessThanLastYear;
    }

    public void setDayOfHandleTimeLessThanLastYear(Double dayOfHandleTimeLessThanLastYear) {
        this.dayOfHandleTimeLessThanLastYear = dayOfHandleTimeLessThanLastYear;
    }

    public String getBaseCityName() {
        return baseCityName;
    }

    public void setBaseCityName(String baseCityName) {
        this.baseCityName = baseCityName;
    }

    public String getBaseAreaName() {
        return baseAreaName;
    }

    public void setBaseAreaName(String baseAreaName) {
        this.baseAreaName = baseAreaName;
    }

    public Integer getNumberOfCooperationArea() {
        return numberOfCooperationArea;
    }

    public void setNumberOfCooperationArea(Integer numberOfCooperationArea) {
        this.numberOfCooperationArea = numberOfCooperationArea;
    }

    public Integer getNumberOfCooperationDepartment() {
        return numberOfCooperationDepartment;
    }

    public void setNumberOfCooperationDepartment(Integer numberOfCooperationDepartment) {
        this.numberOfCooperationDepartment = numberOfCooperationDepartment;
    }

    public Integer getNumberOfSuccessfullyHandled() {
        return numberOfSuccessfullyHandled;
    }

    public void setNumberOfSuccessfullyHandled(Integer numberOfSuccessfullyHandled) {
        this.numberOfSuccessfullyHandled = numberOfSuccessfullyHandled;
    }

    public Double getPersentNumberOfTotal() {
        return persentNumberOfTotal;
    }

    public void setPersentNumberOfTotal(Double persentNumberOfTotal) {
        this.persentNumberOfTotal = persentNumberOfTotal;
    }

    public Integer getApplicantTimes() {
        return applicantTimes;
    }

    public void setApplicantTimes(Integer applicantTimes) {
        this.applicantTimes = applicantTimes;
    }

    public Double getPersentOfApplicantTimes() {
        return persentOfApplicantTimes;
    }

    public void setPersentOfApplicantTimes(Double persentOfApplicantTimes) {
        this.persentOfApplicantTimes = persentOfApplicantTimes;
    }

    public Integer getRejectedApplicants() {
        return rejectedApplicants;
    }

    public void setRejectedApplicants(Integer rejectedApplicants) {
        this.rejectedApplicants = rejectedApplicants;
    }

    public Integer getSuccessfullyHandled() {
        return successfullyHandled;
    }

    public void setSuccessfullyHandled(Integer successfullyHandled) {
        this.successfullyHandled = successfullyHandled;
    }

    public Double getPersentOfSuccessfullyHandled() {
        return persentOfSuccessfullyHandled;
    }

    public void setPersentOfSuccessfullyHandled(Double persentOfSuccessfullyHandled) {
        this.persentOfSuccessfullyHandled = persentOfSuccessfullyHandled;
    }

    public Double getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(Double averageDuration) {
        this.averageDuration = averageDuration;
    }

    public Double getAverageDurationLessThanLastYear() {
        return averageDurationLessThanLastYear;
    }

    public void setAverageDurationLessThanLastYear(Double averageDurationLessThanLastYear) {
        this.averageDurationLessThanLastYear = averageDurationLessThanLastYear;
    }

    public String getReasonForReturn() {
        return reasonForReturn;
    }

    public void setReasonForReturn(String reasonForReturn) {
        this.reasonForReturn = reasonForReturn;
    }

    public Integer getReasonForReturnTimes() {
        return reasonForReturnTimes;
    }

    public void setReasonForReturnTimes(Integer reasonForReturnTimes) {
        this.reasonForReturnTimes = reasonForReturnTimes;
    }

    public List<Case> getCaseTypeList() {
        return caseTypeList;
    }

    public void setCaseTypeList(List<Case> caseTypeList) {
        this.caseTypeList = caseTypeList;
    }

    public List<City> getWorkNumberList() {
        return workNumberList;
    }

    public void setWorkNumberList(List<City> workNumberList) {
        this.workNumberList = workNumberList;
    }

    public List<Brief> getBriefList() {
        return briefList;
    }

    public void setBriefList(List<Brief> briefList) {
        this.briefList = briefList;
    }
}
