package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.implementation;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.WasteCategory;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.repositories.WasteCategoryRepository;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    // This function retrieves a list of all waste categories.
    // It fetches all categories from the repository.
    @Override
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    // This function retrieves a specific waste category based on its ID.
    // It fetches the category from the repository or throws an exception if not found.
    @Override
    public WasteCategory getCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Waste category not found with id: " + id));
    }

    // This function creates a new waste category.
    // It saves the category to the repository.
    @Override
    public WasteCategory createCategory(WasteCategory category) {
        return wasteCategoryRepository.save(category);
    }

    // This function updates an existing waste category based on its ID.
    // It retrieves the existing category, updates its fields, and saves the updated category to the repository.
    @Override
    public WasteCategory updateCategory(Long id, WasteCategory category) {
        WasteCategory existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return wasteCategoryRepository.save(existingCategory);
    }

    // This function deletes a specific waste category based on its ID.
    // It retrieves the category and deletes it from the repository.
    @Override
    public void deleteCategory(Long id) {
        WasteCategory category = getCategoryById(id);
        wasteCategoryRepository.delete(category);
    }
}