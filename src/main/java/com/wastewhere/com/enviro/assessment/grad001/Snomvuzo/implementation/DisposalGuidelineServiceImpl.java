package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.implementation;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.DisposalGuideline;
//import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.repositories.DisposalGuidelineRepository;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.repositories.DisposalGuidelineRepository;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DisposalGuidelineServiceImpl implements DisposalGuidelineService {

    @Autowired
    public DisposalGuidelineRepository disposalGuidelineRepository;

    // This function retrieves a list of all disposal guidelines.
    // It fetches all guidelines from the repository.
    @Override
    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    // This function retrieves a specific disposal guideline based on its ID.
    // It fetches the guideline from the repository or throws an exception if not found.
    @Override
    public DisposalGuideline getGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disposal guideline not found with id: " + id));
    }

    // This function creates a new disposal guideline.
    // It saves the guideline to the repository.
    @Override
    public DisposalGuideline createGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }

    // This function updates an existing disposal guideline based on its ID.
    // It retrieves the existing guideline, updates its fields, and saves the updated guideline to the repository.
    @Override
    public DisposalGuideline updateGuideline(Long id, DisposalGuideline guideline) {
        DisposalGuideline existingGuideline = getGuidelineById(id);
        existingGuideline.setTitle(guideline.getTitle());
        existingGuideline.setContent(guideline.getContent());
        existingGuideline.setWasteCategory(guideline.getWasteCategory());
        return disposalGuidelineRepository.save(existingGuideline);
    }

    // This function deletes a specific disposal guideline based on its ID.
    // It retrieves the guideline and deletes it from the repository.
    @Override
    public void deleteGuideline(Long id) {
        DisposalGuideline guideline = getGuidelineById(id);
        disposalGuidelineRepository.delete(guideline);
    }
}