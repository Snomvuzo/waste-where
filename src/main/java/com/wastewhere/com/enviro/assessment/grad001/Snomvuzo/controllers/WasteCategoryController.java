package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.controllers;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.WasteCategory;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    // This function retrieves a list of all waste categories.
    // It sends a GET request to the /api/waste-categories endpoint and returns the categories with an HTTP status of OK (200).
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        List<WasteCategory> categories = wasteCategoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // This function retrieves a specific waste category based on its ID.
    // It sends a GET request to the /api/waste-categories/{id} endpoint and returns the category with an HTTP status of OK (200).
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        WasteCategory category = wasteCategoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // This function creates a new waste category.
    // It sends a POST request to the /api/waste-categories endpoint with the category data in the request body.
    // It returns the created category with an HTTP status of CREATED (201).
    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategory category) {
        WasteCategory newCategory = wasteCategoryService.createCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    // This function updates an existing waste category based on its ID.
    // It sends a PUT request to the /api/waste-categories/{id} endpoint with the updated category data in the request body.
    // It returns the updated category with an HTTP status of OK (200).
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        WasteCategory updatedCategory = wasteCategoryService.updateCategory(id, category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    // This function deletes a specific waste category based on its ID.
    // It sends a DELETE request to the /api/waste-categories/{id} endpoint and returns an HTTP status of NO CONTENT (204).
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}