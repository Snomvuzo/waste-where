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

    @Override
    public List<RecyclingTip> getAllTips() {
        return recyclingTipRepository.findAll();
    }

    @Override
    public RecyclingTip getTipById(Long id) {
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recycling tip not found with id: " + id));
    }

    @Override
    public RecyclingTip createTip(RecyclingTip tip) {
        return recyclingTipRepository.save(tip);
    }

    @Override
    public RecyclingTip updateTip(Long id, RecyclingTip tip) {
        RecyclingTip existingTip = getTipById(id);
        existingTip.setTitle(tip.getTitle());
        existingTip.setContent(tip.getContent());
        return recyclingTipRepository.save(existingTip);
    }

    @Override
    public void deleteTip(Long id) {
        RecyclingTip tip = getTipById(id);
        recyclingTipRepository.delete(tip);
    }
}