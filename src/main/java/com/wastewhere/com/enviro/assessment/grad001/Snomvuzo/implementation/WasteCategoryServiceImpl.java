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

    @Override
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    @Override
    public WasteCategory getCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Waste category not found with id: " + id));
    }

    @Override
    public WasteCategory createCategory(WasteCategory category) {
        return wasteCategoryRepository.save(category);
    }

    @Override
    public WasteCategory updateCategory(Long id, WasteCategory category) {
        WasteCategory existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return wasteCategoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        WasteCategory category = getCategoryById(id);
        wasteCategoryRepository.delete(category);
    }
}