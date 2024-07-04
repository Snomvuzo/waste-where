package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.services;

import com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models.RecyclingTip;

import java.util.List;

public interface RecyclingTipService {
    List<RecyclingTip> getAllTips();
    RecyclingTip getTipById(Long id);
    RecyclingTip createTip(RecyclingTip tip);
    RecyclingTip updateTip(Long id, RecyclingTip tip);
    void deleteTip(Long id);
}