package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.repositories;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}