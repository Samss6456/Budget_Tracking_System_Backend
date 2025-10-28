package com.examly.springapp.dto;

public class BudgetSummary {
    private String categoryName;
    private Double allocatedAmount;
    private Double spentAmount;
    private Double remainingAmount;

    public BudgetSummary(String categoryName, Double allocatedAmount, Double spentAmount, Double remainingAmount) {
        this.categoryName = categoryName;
        this.allocatedAmount = allocatedAmount;
        this.spentAmount = spentAmount;
        this.remainingAmount = remainingAmount;
    }

    public BudgetSummary() {}

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public Double getAllocatedAmount() { return allocatedAmount; }
    public void setAllocatedAmount(Double allocatedAmount) { this.allocatedAmount = allocatedAmount; }

    public Double getSpentAmount() { return spentAmount; }
    public void setSpentAmount(Double spentAmount) { this.spentAmount = spentAmount; }

    public Double getRemainingAmount() { return remainingAmount; }
    public void setRemainingAmount(Double remainingAmount) { this.remainingAmount = remainingAmount; }
}