package com.example.Mgnrega.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Recordsdto {

    @JsonProperty("fin_year")
    private String finYear;

    @JsonProperty("month")
    private String month;

    @JsonProperty("state_code")
    private String stateCode;

    @JsonProperty("state_name")
    private String stateName;

    @JsonProperty("district_code")
    private String districtCode;

    @JsonProperty("district_name")
    private String districtName;

    @JsonProperty("Approved_Labour_Budget")
    private Double approvedLabourBudget;

    @JsonProperty("Average_Wage_rate_per_day_per_person")
    private Double averageWageRatePerDayPerPerson;

    @JsonProperty("Average_days_of_employment_provided_per_Household")
    private Double averageDaysOfEmploymentProvidedPerHousehold;

    @JsonProperty("Differently_abled_persons_worked")
    private Double differentlyAbledPersonsWorked;

    @JsonProperty("Material_and_skilled_Wages")
    private Double materialAndSkilledWages;

    @JsonProperty("Number_of_Completed_Works")
    private Double numberOfCompletedWorks;

    @JsonProperty("Number_of_GPs_with_NIL_exp")
    private Double numberOfGPsWithNilExp;

    @JsonProperty("Number_of_Ongoing_Works")
    private Double numberOfOngoingWorks;

    @JsonProperty("Persondays_of_Central_Liability_so_far")
    private Double persondaysOfCentralLiabilitySoFar;

    @JsonProperty("SC_persondays")
    private Double scPersondays;

    @JsonProperty("SC_workers_against_active_workers")
    private Double scWorkersAgainstActiveWorkers;

    @JsonProperty("ST_persondays")
    private Double stPersondays;

    @JsonProperty("ST_workers_against_active_workers")
    private Double stWorkersAgainstActiveWorkers;

    @JsonProperty("Total_Adm_Expenditure")
    private Double totalAdmExpenditure;

    @JsonProperty("Total_Exp")
    private Double totalExp;

    @JsonProperty("Total_Households_Worked")
    private Double totalHouseholdsWorked;

    @JsonProperty("Total_Individuals_Worked")
    private Double totalIndividualsWorked;

    @JsonProperty("Total_No_of_Active_Job_Cards")
    private Double totalNoOfActiveJobCards;

    @JsonProperty("Total_No_of_Active_Workers")
    private Double totalNoOfActiveWorkers;

    @JsonProperty("Total_No_of_HHs_completed_100_Days_of_Wage_Employment")
    private Double totalNoOfHHsCompleted100DaysOfWageEmployment;

    @JsonProperty("Total_No_of_JobCards_issued")
    private Double totalNoOfJobCardsIssued;

    @JsonProperty("Total_No_of_Workers")
    private Double totalNoOfWorkers;

    @JsonProperty("Total_No_of_Works_Takenup")
    private Double totalNoOfWorksTakenup;

    @JsonProperty("Wages")
    private Double wages;

    @JsonProperty("Women_Persondays")
    private Double womenPersondays;

    @JsonProperty("percent_of_Category_B_Works")
    private Double percentOfCategoryBWorks;

    @JsonProperty("percent_of_Expenditure_on_Agriculture_Allied_Works")
    private Double percentOfExpenditureOnAgricultureAlliedWorks;

    @JsonProperty("percent_of_NRM_Expenditure")
    private Double percentOfNRMExpenditure;

    @JsonProperty("percentage_payments_gererated_within_15_days")
    private Double percentagePaymentsGeneratedWithin15Days;

    @JsonProperty("Remarks")
    private String remarks;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // ✅ Getters and Setters
    public String getFinYear() { return finYear; }
    public void setFinYear(String finYear) { this.finYear = finYear; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public String getStateCode() { return stateCode; }
    public void setStateCode(String stateCode) { this.stateCode = stateCode; }

    public String getStateName() { return stateName; }
    public void setStateName(String stateName) { this.stateName = stateName; }

    public String getDistrictCode() { return districtCode; }
    public void setDistrictCode(String districtCode) { this.districtCode = districtCode; }

    public String getDistrictName() { return districtName; }
    public void setDistrictName(String districtName) { this.districtName = districtName; }

    public Double getApprovedLabourBudget() { return approvedLabourBudget; }
    public void setApprovedLabourBudget(Double approvedLabourBudget) { this.approvedLabourBudget = approvedLabourBudget; }

    public Double getAverageWageRatePerDayPerPerson() { return averageWageRatePerDayPerPerson; }
    public void setAverageWageRatePerDayPerPerson(Double averageWageRatePerDayPerPerson) { this.averageWageRatePerDayPerPerson = averageWageRatePerDayPerPerson; }

    public Double getAverageDaysOfEmploymentProvidedPerHousehold() { return averageDaysOfEmploymentProvidedPerHousehold; }
    public void setAverageDaysOfEmploymentProvidedPerHousehold(Double averageDaysOfEmploymentProvidedPerHousehold) { this.averageDaysOfEmploymentProvidedPerHousehold = averageDaysOfEmploymentProvidedPerHousehold; }

    public Double getDifferentlyAbledPersonsWorked() { return differentlyAbledPersonsWorked; }
    public void setDifferentlyAbledPersonsWorked(Double differentlyAbledPersonsWorked) { this.differentlyAbledPersonsWorked = differentlyAbledPersonsWorked; }

    public Double getMaterialAndSkilledWages() { return materialAndSkilledWages; }
    public void setMaterialAndSkilledWages(Double materialAndSkilledWages) { this.materialAndSkilledWages = materialAndSkilledWages; }

    public Double getNumberOfCompletedWorks() { return numberOfCompletedWorks; }
    public void setNumberOfCompletedWorks(Double numberOfCompletedWorks) { this.numberOfCompletedWorks = numberOfCompletedWorks; }

    public Double getNumberOfGPsWithNilExp() { return numberOfGPsWithNilExp; }
    public void setNumberOfGPsWithNilExp(Double numberOfGPsWithNilExp) { this.numberOfGPsWithNilExp = numberOfGPsWithNilExp; }

    public Double getNumberOfOngoingWorks() { return numberOfOngoingWorks; }
    public void setNumberOfOngoingWorks(Double numberOfOngoingWorks) { this.numberOfOngoingWorks = numberOfOngoingWorks; }

    public Double getPersondaysOfCentralLiabilitySoFar() { return persondaysOfCentralLiabilitySoFar; }
    public void setPersondaysOfCentralLiabilitySoFar(Double persondaysOfCentralLiabilitySoFar) { this.persondaysOfCentralLiabilitySoFar = persondaysOfCentralLiabilitySoFar; }

    public Double getScPersondays() { return scPersondays; }
    public void setScPersondays(Double scPersondays) { this.scPersondays = scPersondays; }

    public Double getScWorkersAgainstActiveWorkers() { return scWorkersAgainstActiveWorkers; }
    public void setScWorkersAgainstActiveWorkers(Double scWorkersAgainstActiveWorkers) { this.scWorkersAgainstActiveWorkers = scWorkersAgainstActiveWorkers; }

    public Double getStPersondays() { return stPersondays; }
    public void setStPersondays(Double stPersondays) { this.stPersondays = stPersondays; }

    public Double getStWorkersAgainstActiveWorkers() { return stWorkersAgainstActiveWorkers; }
    public void setStWorkersAgainstActiveWorkers(Double stWorkersAgainstActiveWorkers) { this.stWorkersAgainstActiveWorkers = stWorkersAgainstActiveWorkers; }

    public Double getTotalAdmExpenditure() { return totalAdmExpenditure; }
    public void setTotalAdmExpenditure(Double totalAdmExpenditure) { this.totalAdmExpenditure = totalAdmExpenditure; }

    public Double getTotalExp() { return totalExp; }
    public void setTotalExp(Double totalExp) { this.totalExp = totalExp; }

    public Double getTotalHouseholdsWorked() { return totalHouseholdsWorked; }
    public void setTotalHouseholdsWorked(Double totalHouseholdsWorked) { this.totalHouseholdsWorked = totalHouseholdsWorked; }

    public Double getTotalIndividualsWorked() { return totalIndividualsWorked; }
    public void setTotalIndividualsWorked(Double totalIndividualsWorked) { this.totalIndividualsWorked = totalIndividualsWorked; }

    public Double getTotalNoOfActiveJobCards() { return totalNoOfActiveJobCards; }
    public void setTotalNoOfActiveJobCards(Double totalNoOfActiveJobCards) { this.totalNoOfActiveJobCards = totalNoOfActiveJobCards; }

    public Double getTotalNoOfActiveWorkers() { return totalNoOfActiveWorkers; }
    public void setTotalNoOfActiveWorkers(Double totalNoOfActiveWorkers) { this.totalNoOfActiveWorkers = totalNoOfActiveWorkers; }

    public Double getTotalNoOfHHsCompleted100DaysOfWageEmployment() { return totalNoOfHHsCompleted100DaysOfWageEmployment; }
    public void setTotalNoOfHHsCompleted100DaysOfWageEmployment(Double totalNoOfHHsCompleted100DaysOfWageEmployment) { this.totalNoOfHHsCompleted100DaysOfWageEmployment = totalNoOfHHsCompleted100DaysOfWageEmployment; }

    public Double getTotalNoOfJobCardsIssued() { return totalNoOfJobCardsIssued; }
    public void setTotalNoOfJobCardsIssued(Double totalNoOfJobCardsIssued) { this.totalNoOfJobCardsIssued = totalNoOfJobCardsIssued; }

    public Double getTotalNoOfWorkers() { return totalNoOfWorkers; }
    public void setTotalNoOfWorkers(Double totalNoOfWorkers) { this.totalNoOfWorkers = totalNoOfWorkers; }

    public Double getTotalNoOfWorksTakenup() { return totalNoOfWorksTakenup; }
    public void setTotalNoOfWorksTakenup(Double totalNoOfWorksTakenup) { this.totalNoOfWorksTakenup = totalNoOfWorksTakenup; }

    public Double getWages() { return wages; }
    public void setWages(Double wages) { this.wages = wages; }

    public Double getWomenPersondays() { return womenPersondays; }
    public void setWomenPersondays(Double womenPersondays) { this.womenPersondays = womenPersondays; }

    public Double getPercentOfCategoryBWorks() { return percentOfCategoryBWorks; }
    public void setPercentOfCategoryBWorks(Double percentOfCategoryBWorks) { this.percentOfCategoryBWorks = percentOfCategoryBWorks; }

    public Double getPercentOfExpenditureOnAgricultureAlliedWorks() { return percentOfExpenditureOnAgricultureAlliedWorks; }
    public void setPercentOfExpenditureOnAgricultureAlliedWorks(Double percentOfExpenditureOnAgricultureAlliedWorks) { this.percentOfExpenditureOnAgricultureAlliedWorks = percentOfExpenditureOnAgricultureAlliedWorks; }

    public Double getPercentOfNRMExpenditure() { return percentOfNRMExpenditure; }
    public void setPercentOfNRMExpenditure(Double percentOfNRMExpenditure) { this.percentOfNRMExpenditure = percentOfNRMExpenditure; }

    public Double getPercentagePaymentsGeneratedWithin15Days() { return percentagePaymentsGeneratedWithin15Days; }
    public void setPercentagePaymentsGeneratedWithin15Days(Double percentagePaymentsGeneratedWithin15Days) { this.percentagePaymentsGeneratedWithin15Days = percentagePaymentsGeneratedWithin15Days; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
