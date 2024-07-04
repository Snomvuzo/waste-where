package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.WasteCategory;

import java.util.List;

public interface WasteCategoryService {
    List<WasteCategory> getAllCategories();
    WasteCategory getCategoryById(Long id);
    WasteCategory createCategory(WasteCategory category);
    WasteCategory updateCategory(Long id, WasteCategory category);
    void deleteCategory(Long id);
}