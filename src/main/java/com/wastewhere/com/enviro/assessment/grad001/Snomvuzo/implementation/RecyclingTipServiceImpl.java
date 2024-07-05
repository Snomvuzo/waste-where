package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.implementation;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.RecyclingTip;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.repositories.RecyclingTipRepository;
import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    // This function retrieves a list of all recycling tips.
    // It fetches all tips from the repository.
    @Override
    public List<RecyclingTip> getAllTips() {
        return recyclingTipRepository.findAll();
    }

    // This function retrieves a specific recycling tip based on its ID.
    // It fetches the tip from the repository or throws an exception if not found.
    @Override
    public RecyclingTip getTipById(Long id) {
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recycling tip not found with id: " + id));
    }

    // This function creates a new recycling tip.
    // It saves the tip to the repository.
    @Override
    public RecyclingTip createTip(RecyclingTip tip) {
        return recyclingTipRepository.save(tip);
    }

    // This function updates an existing recycling tip based on its ID.
    // It retrieves the existing tip, updates its fields, and saves the updated tip to the repository.
    @Override
    public RecyclingTip updateTip(Long id, RecyclingTip tip) {
        RecyclingTip existingTip = getTipById(id);
        existingTip.setTitle(tip.getTitle());
        existingTip.setContent(tip.getContent());
        return recyclingTipRepository.save(existingTip);
    }

    // This function deletes a specific recycling tip based on its ID.
    // It retrieves the tip and deletes it from the repository.
    @Override
    public void deleteTip(Long id) {
        RecyclingTip tip = getTipById(id);
        recyclingTipRepository.delete(tip);
    }
}