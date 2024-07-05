package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.controllers;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.WasteCategory;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste")
public class WasteManagementController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    // This function retrieves a list of all waste categories.
    // It sends a GET request to the /api/waste/categories endpoint and returns the categories with an HTTP status of OK (200).
    @GetMapping("/categories")
    public ResponseEntity<List<WasteCategory>> getWasteCategories() {
        List<WasteCategory> categories = wasteCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // This function retrieves a specific waste category based on its ID.
    // It sends a GET request to the /api/waste/categories/{id} endpoint and returns the category with an HTTP status of OK (200).
    @GetMapping("/categories/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        WasteCategory category = wasteCategoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    // This function creates a new waste category.
    // It sends a POST request to the /api/waste/categories endpoint with the category data in the request body.
    // It returns the created category with an HTTP status of CREATED (201).
    @PostMapping("/categories")
    public ResponseEntity<WasteCategory> createCategory(@RequestBody WasteCategory category) {
        WasteCategory createdCategory = wasteCategoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // This function updates an existing waste category based on its ID.
    // It sends a PUT request to the /api/waste/categories/{id} endpoint with the updated category data in the request body.
    // It returns the updated category with an HTTP status of OK (200).
    @PutMapping("/categories/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @RequestBody WasteCategory category) {
        WasteCategory updatedCategory = wasteCategoryService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    // This function deletes a specific waste category based on its ID.
    // It sends a DELETE request to the /api/waste/categories/{id} endpoint and returns an HTTP status of NO CONTENT (204).
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}