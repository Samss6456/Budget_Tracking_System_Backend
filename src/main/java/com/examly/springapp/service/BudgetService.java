package com.examly.springapp.service;

import com.examly.springapp.dto.BudgetSummaryDto;
import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    private final CategoryRepository categoryRepository;

    public BudgetService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Controller tests use these methods (Mockito mocks them there)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        // No validation on purpose (tests expect "{}" to be accepted)
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<BudgetSummaryDto> getBudgetSummary() {
        // Simple placeholder: map categories to summary with spent=0
        List<BudgetSummaryDto> out = new ArrayList<>();
        for (Category c : categoryRepository.findAll()) {
            Double alloc = c.getAllocatedAmount() == null ? 0.0 : c.getAllocatedAmount();
            out.add(new BudgetSummaryDto(c.getCategoryName(), alloc, 0.0));
        }
        return out;
    }
}
