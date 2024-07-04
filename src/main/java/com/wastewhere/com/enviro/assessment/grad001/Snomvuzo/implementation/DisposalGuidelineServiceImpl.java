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

    @Override
    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    @Override
    public DisposalGuideline getGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disposal guideline not found with id: " + id));
    }

    @Override
    public DisposalGuideline createGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }

    @Override
    public DisposalGuideline updateGuideline(Long id, DisposalGuideline guideline) {
        DisposalGuideline existingGuideline = getGuidelineById(id);
        existingGuideline.setTitle(guideline.getTitle());
        existingGuideline.setContent(guideline.getContent());
        existingGuideline.setWasteCategory(guideline.getWasteCategory());
        return disposalGuidelineRepository.save(existingGuideline);
    }

    @Override
    public void deleteGuideline(Long id) {
        DisposalGuideline guideline = getGuidelineById(id);
        disposalGuidelineRepository.delete(guideline);
    }
}