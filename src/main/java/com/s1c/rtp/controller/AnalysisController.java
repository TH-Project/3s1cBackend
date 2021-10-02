package com.s1c.rtp.controller;

import java.util.Arrays;
import java.util.List;

import com.s1c.rtp.entity.genderanalysis;
import com.s1c.rtp.entity.news;
import com.s1c.rtp.repository.NewsRepository;
import com.s1c.rtp.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AnalysisController {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    GenderRepository genderRepository;

    @GetMapping("/real-time-popularity/news/all")
    public List<news> retrieveAllNews(){
        List<news> result = newsRepository.findAll();
        return result;
    }

    @GetMapping("/real-time-popularity/gender/all")
    public List<genderanalysis> retrieveAllGender(){
        List<genderanalysis> results = genderRepository.findAll();
        return results;
    }
}
