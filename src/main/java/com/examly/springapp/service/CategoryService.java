package com.examly.springapp.service;

import com.examly.springapp.dto.BudgetSummary;
import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category addCategory(Category c) {
        if (c.getCategoryName() == null || c.getCategoryName().trim().isEmpty())
            throw new IllegalArgumentException("categoryName is required");
        if (c.getAllocatedAmount() == null)
            throw new IllegalArgumentException("allocatedAmount is required");
        // description allowed empty in frontend, but keep non-null
        if (c.getDescription() == null) c.setDescription("");

        return repo.save(c);
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public List<BudgetSummary> getSummary() {
        return repo.findAll().stream()
            .map(cat -> {
                double spent = 0.0; // no expenses API yet
                double alloc = cat.getAllocatedAmount() == null ? 0.0 : cat.getAllocatedAmount();
                return new BudgetSummary(cat.getCategoryName(), alloc, spent, alloc - spent);
            })
            .collect(Collectors.toList());
    }
}
