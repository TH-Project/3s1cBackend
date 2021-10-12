package com.s1c.rtp.controller;

import java.util.Arrays;
import java.util.List;


import com.s1c.rtp.dto.*;
import com.s1c.rtp.entity.*;
import com.s1c.rtp.repository.*;
import com.s1c.rtp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @Autowired
    CommentsService commentsService;

    @Autowired
    KeywordService keywordService;

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
    public Long returnNumOfNews(){
        return wholeDataService.returnNumOfNews();
    }

    @GetMapping("/analysis/WritersNComments")
    public GroupByDto returnNumOfWritersNComments(){
        return commentsService.returnNumOfWritersNComments();
    }

    @GetMapping("/analysis/keyword/BiggerThanRate/{rate}")
    public List<KeywordDto> returnBiggerThanRate(@PathVariable("rate") double rate){
        return keywordService.returnBiggerThanRate(rate);
    }

    @GetMapping("/analysis/keyword/BiggerThanCount/{count}")
    public List<KeywordDto> returnBiggerThanCount(@PathVariable("count") int count){
        return keywordService.returnBiggerThanCount(count);
    }

}
