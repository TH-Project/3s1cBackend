package com.s1c.rtp.controller;

import java.util.Arrays;
import java.util.List;

import com.s1c.rtp.dto.CommentsDto;
import com.s1c.rtp.dto.GenderDto;
import com.s1c.rtp.entity.genderanalysis;
import com.s1c.rtp.entity.news;
import com.s1c.rtp.repository.CommentsRepository;
import com.s1c.rtp.repository.NewsRepository;
import com.s1c.rtp.repository.GenderRepository;
import com.s1c.rtp.service.WholeDataService;
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

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    WholeDataService wholeDataService;

    @GetMapping("/real-time-popularity/news/all")
    public List<news> retrieveAllNews(){
        return newsRepository.findAll();
    }

    @GetMapping("/real-time-popularity/gender/all")
    public List<genderanalysis> retrieveAllGender(){
        return genderRepository.findAll();
    }

    @GetMapping("/real-time-popularity/genderDto/all")
    public List<GenderDto> retrieveAllGenderDto(){
        return genderRepository.findGenderDto();
    }

    @GetMapping("/real-time-popularity/commentsDto/withNews")
    public List<CommentsDto> returnCommentsWithNews(){
        return commentsRepository.findCommentsWithNews();
    }

    @GetMapping("/analysis/total-number-comments")
    public Long returnNumOfComments(){
        return wholeDataService.returnNumOfComments();
    }

    @GetMapping("/analysis/total-number-news")
    public Long returnNumOfNew(){
        return wholeDataService.returnNumOfNews();
    }

}
