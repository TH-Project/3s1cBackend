package com.s1c.rtp.controller;

import java.util.Arrays;
import java.util.HashMap;
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

    @GetMapping("/analysis/total-number-writers")
    public Long returnNumOfWriters(){ return commentsService.returnNumOfWriters(); }

    @GetMapping("/analysis/WritersNComments")
    public GroupByDto returnNumOfWritersNComments(){ return commentsService.returnNumOfWritersNComments(); }

    @GetMapping("/analysis/keywords/bigger-than-rate/{rate}")
    public List<KeywordDto> returnBiggerThanRate(@PathVariable("rate") double rate){
        return keywordService.returnBiggerThanRate(rate);
    }

    @GetMapping("/analysis/keywords/bigger-than-count/{count}")
    public List<KeywordDto> returnBiggerThanCount(@PathVariable("count") int count){
        return keywordService.returnBiggerThanCount(count);
    }

    @GetMapping("/analysis/comments/time-graph")
    public JSONObject returnTimeGraph(){
        return commentsService.returnCommentsNTime();
    }

    @GetMapping("/keywords/{keyword}/news-summary")
    public Page<String> retrieveBreifNews(@PathVariable("keyword") String keyword) {
        return newsService.retrieveBriefNewsByKeyword(keyword);
    }

    @GetMapping("/keywords/{keyword}/gender-ratio")
    public HashMap<String, Double> retrieveGenderRatio(@PathVariable("keyword") String keyword) {
        return newsService.retrieveGenderRatioByKeyword(keyword);
    }

    @GetMapping("/keywords/{keyword}/age-ratio")
    public HashMap<String, Double> retrieveAgeRatio(@PathVariable("keyword") String keyword) {
        return newsService.retrieveAgeRatioByKeyword(keyword);
    }

    @GetMapping("/real-time-popularity")
    public List<RtpDto> retriveAllPopularity() {
        return  keywordService.returnRealTimePopularity();
    }

    @GetMapping("/keywords/{keyword}/ranks-mentions")
    public HashMap<String, Integer> retrieveRanksAndMetions(@PathVariable("keyword") String keyword) {
        return keywordService.retrieveRanksAndMentions(keyword);
    }

    @GetMapping("/keywords/{keyword}/related-articles")
    public List<RelatedNewsDto> retrieveRelatedArticles(@PathVariable("keyword") String keyword) {
        return keywordService.retrieveRelatedArticles(keyword);
    }
    @GetMapping("/analysis/users/heavy-user")
    public Page<CommentsUserDto> retrieveHeavyUser() {
        return commentsService.retrieveHeavyUser();
    }

    @GetMapping("/analysis/having-many-comments")
    public List<CommentsDto2> retrieveNewsManyComments() {
        return commentsService.returnNewsHasManyCommentsTopThree();
    }

    @GetMapping("/keywords/{keyword}/emoticon-analysis")
    public KeywordDto2 returnKeywordEmoticon(@PathVariable("keyword") String keyword) {
        return keywordService.returnKeywordEmoticon(keyword);
    }

    @GetMapping("/keywords/{keyword}/wordcloud")
    public List<RelKeywordDto> retriveRelkeywordByKeyword(@PathVariable("keyword") String keyword) {
        return relKeywordService.retrieveRelkeywordByKeyword(keyword);
    }

    @GetMapping("/keywords/{keyword}/tags")
    public List<String> retrieveRelatedKeyword(@PathVariable("keyword") String keyword) {
        return relKeywordService.retrieveRelatedKeyword(keyword);
    }

    @GetMapping("/analysis/cumulative-statistics")
    public WholeDataDto2 returnCumulativeStatistic() {
        return wholeDataService.returnNumOfWholeData();
    }

    @GetMapping("/analysis/gender-age-statistics")
    public GenderAgeDto returnGenderAgeStatistic() {
        return newsService.returnGenderAgeStatistics();
    }





}
