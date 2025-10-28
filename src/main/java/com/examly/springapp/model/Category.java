package com.examly.springapp.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private Double allocatedAmount;
    private String description;

    public Category() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public Double getAllocatedAmount() { return allocatedAmount; }

    // 👇 ADD THESE TWO OVERLOADED SETTERS 👇
    public void setAllocatedAmount(Double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public void setAllocatedAmount(int allocatedAmount) {
        this.allocatedAmount = (double) allocatedAmount;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
