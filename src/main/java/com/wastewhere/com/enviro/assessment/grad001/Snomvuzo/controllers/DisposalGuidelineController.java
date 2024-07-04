package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.controllers;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.DisposalGuideline;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    // This method retrieves a list of all disposal guidelines.
    // It sends a GET request to the /api/disposal-guidelines endpoint
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines() {
        List<DisposalGuideline> guidelines = disposalGuidelineService.getAllGuidelines();
        return new ResponseEntity<>(guidelines, HttpStatus.OK);
    }

    // This function creates a new disposal guideline.
    // It sends a POST request to the /api/disposal-guidelines endpoint with the guideline data in the request body.
    // It returns the created guideline with an HTTP status of CREATED (201).
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        DisposalGuideline guideline = disposalGuidelineService.getGuidelineById(id);
        return new ResponseEntity<>(guideline, HttpStatus.OK);
    }

    // This function updates an existing disposal guideline based on its ID.
    // It sends a PUT request to the /api/disposal-guidelines/{id} endpoint with the updated guideline data in the request body.
    // It returns the updated guideline with an HTTP status of OK(200).
    @PostMapping
    public ResponseEntity<DisposalGuideline> createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        DisposalGuideline newGuideline = disposalGuidelineService.createGuideline(guideline);
        return new ResponseEntity<>(newGuideline, HttpStatus.CREATED);
    }

    //This function updates an existing disposal guideline based on its ID.
    // It sends a PUT request to the /api/disposal-guidelines/{id} endpoint with the updated guideline data in the request body.
    // It returns the updated guideline with an HTTP status of OK (200).
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        DisposalGuideline updatedGuideline = disposalGuidelineService.updateGuideline(id, guideline);
        return new ResponseEntity<>(updatedGuideline, HttpStatus.OK);
    }

    // This function deletes a specific disposal guideline based on its ID.
    //  It sends a DELETE request to the /api/disposal-guidelines/{id} endpoint and returns an HTTP status of NO CONTENT (204).
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteGuideline(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}