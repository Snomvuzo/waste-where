package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.controllers;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.RecyclingTip;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

     // This function retrieves a list of all recycling tips.
     // It sends a GET request to the /api/recycling-tips endpoint and returns the tips with an HTTP status of OK (200).
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips() {
        List<RecyclingTip> tips = recyclingTipService.getAllTips();
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

    // This function retrieves a specific recycling tip based on its ID.
    // It sends a GET request to the /api/recycling-tips/{id} endpoint and returns the tip with an HTTP status of OK (200).
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        RecyclingTip tip = recyclingTipService.getTipById(id);
        return new ResponseEntity<>(tip, HttpStatus.OK);
    }

    // This function creates a new recycling tip.
    // It sends a POST request to the /api/recycling-tips endpoint with the tip data in the request body.
    // It returns the created tip with an HTTP status of CREATED (201).
    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip) {
        RecyclingTip newTip = recyclingTipService.createTip(tip);
        return new ResponseEntity<>(newTip, HttpStatus.CREATED);
    }

    // This function updates an existing recycling tip based on its ID.
    // It sends a PUT request to the /api/recycling-tips/{id} endpoint with the updated tip data in the request body.
    // It returns the updated tip with an HTTP status of OK (200).
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        RecyclingTip updatedTip = recyclingTipService.updateTip(id, tip);
        return new ResponseEntity<>(updatedTip, HttpStatus.OK);
    }

    // This function deletes a specific recycling tip based on its ID.
    // It sends a DELETE request to the /api/recycling-tips/{id} endpoint and returns an HTTP status of NO CONTENT (204).
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        recyclingTipService.deleteTip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}