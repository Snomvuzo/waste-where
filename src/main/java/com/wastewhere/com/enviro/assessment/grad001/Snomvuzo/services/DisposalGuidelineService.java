package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.DisposalGuideline;

import java.util.List;

public interface DisposalGuidelineService {
    List<DisposalGuideline> getAllGuidelines();
    DisposalGuideline getGuidelineById(Long id);
    DisposalGuideline createGuideline(DisposalGuideline guideline);
    DisposalGuideline updateGuideline(Long id, DisposalGuideline guideline);
    void deleteGuideline(Long id);
}