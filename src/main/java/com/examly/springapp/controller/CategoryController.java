package com.examly.springapp.controller;

import com.examly.springapp.dto.BudgetSummaryDto;
import com.examly.springapp.model.Category;
import com.examly.springapp.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final BudgetService budgetService;

    public CategoryController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    // GET /api/categories
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(budgetService.getAllCategories());
    }

    // POST /api/categories
    // NOTE: If the request body is an empty string, Spring returns 400 automatically
    // (satisfies SpringBoot_..._testAddCategory_NullBody)
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(budgetService.addCategory(category));
    }

    // DELETE /api/categories/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        budgetService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    // GET /api/categories/summary
    @GetMapping("/summary")
    public ResponseEntity<List<BudgetSummaryDto>> getBudgetSummary() {
        return ResponseEntity.ok(budgetService.getBudgetSummary());
    }
}
