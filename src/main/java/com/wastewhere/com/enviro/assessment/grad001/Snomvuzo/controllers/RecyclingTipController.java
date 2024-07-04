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

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips() {
        List<RecyclingTip> tips = recyclingTipService.getAllTips();
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        RecyclingTip tip = recyclingTipService.getTipById(id);
        return new ResponseEntity<>(tip, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip) {
        RecyclingTip newTip = recyclingTipService.createTip(tip);
        return new ResponseEntity<>(newTip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        RecyclingTip updatedTip = recyclingTipService.updateTip(id, tip);
        return new ResponseEntity<>(updatedTip, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        recyclingTipService.deleteTip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}