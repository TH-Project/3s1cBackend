package com.s1c.rtp.controller;

import java.util.List;

import com.s1c.rtp.dto.*;
import com.s1c.rtp.entity.*;
import com.s1c.rtp.repository.*;
import com.s1c.rtp.service.*;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    NewsService newsService;

    @Autowired
    RelKeywordService relKeywordService;

    @GetMapping("/real-time-popularity/news/all")
    public List<news> getAllNews(){
        return newsRepository.findAll();
    }

    @GetMapping("/real-time-popularity/gender/all")
    public List<genderanalysis> getAllGender(){
        return genderRepository.findAll();
    }

    @GetMapping("/real-time-popularity/genderDto/all")
    public List<GenderDto> getAllGenderDto(){
        return genderRepository.findGenderDto();
    }

    @GetMapping("/real-time-popularity/commentsDto/withNews")
    public List<CommentsDto> getCommentsWithNews(){
        return commentsRepository.findCommentsWithNews();
    }

    @GetMapping("/analysis/total-number-comments")
    public Long getNumOfComments(){
        return wholeDataService.findNumOfComments();
    }

    @GetMapping("/analysis/total-number-news")
    public Long getNumOfNews(){
        return wholeDataService.findNumOfNews();
    }

    @GetMapping("/analysis/total-number-writers")
    public Long getNumOfWriters(){ return commentsService.findNumOfWriters(); }

    @GetMapping("/analysis/WritersNComments")
    public GroupByDto getNumOfWritersNComments(){ return commentsService.findNumOfWritersNComments(); }

    @GetMapping("/analysis/keywords/bigger-than-rate/{rate}")
    public List<KeywordDto> getBiggerThanRate(@PathVariable("rate") double rate){
        return keywordService.findBiggerThanRate(rate);
    }

    @GetMapping("/analysis/keywords/bigger-than-count/{count}")
    public List<KeywordDto> getBiggerThanCount(@PathVariable("count") int count){
        return keywordService.findBiggerThanCount(count);
    }

    @GetMapping("/analysis/comments/time-graph")
    public JSONObject getTimeGraph(){
        return commentsService.findCommentsNTime();
    }

    @GetMapping("/real-time-popularity")
    public List<RtpDto> getAllPopularity() {
        return  keywordService.findRealTimePopularity();
    }

    @GetMapping("/analysis/users/heavy-user")
    public Page<CommentsUserDto> getHeavyUser() {
        return commentsService.findHeavyUser();
    }

    @GetMapping("/analysis/having-many-comments")
    public List<CommentsDto2> getNewsManyComments() {
        return commentsService.findNewsHasManyCommentsTopThree();
    }

    @GetMapping("/analysis/cumulative-statistics")
    public WholeDataDto2 getCumulativeStatistic() {
        return wholeDataService.findNumOfWholeData();
    }

    @GetMapping("/analysis/gender-age-statistics")
    public GenderAgeDto getGenderAgeStatistic() {
        return newsService.findGenderAgeStatistics();
    }
}
