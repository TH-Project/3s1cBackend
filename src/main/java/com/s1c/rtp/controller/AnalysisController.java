package com.s1c.rtp.controller;

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

    @GetMapping("/keywords/{keyword}/news-summary")
    public Page<String> getBreifNews(@PathVariable("keyword") String keyword) {
        return newsService.findBriefNewsByKeyword(keyword);
    }

    @GetMapping("/keywords/{keyword}/gender-ratio")
    public HashMap<String, Double> getGenderRatio(@PathVariable("keyword") String keyword) {
        return newsService.findGenderRatioByKeyword(keyword);
    }

    @GetMapping("/keywords/{keyword}/age-ratio")
    public HashMap<String, Double> getAgeRatio(@PathVariable("keyword") String keyword) {
        return newsService.findAgeRatioByKeyword(keyword);
    }

    @GetMapping("/real-time-popularity")
    public List<RtpDto> getAllPopularity() {
        return  keywordService.findRealTimePopularity();
    }

    @GetMapping("/keywords/{keyword}/ranks-mentions")
    public HashMap<String, Integer> getRanksAndMetions(@PathVariable("keyword") String keyword) {
        return keywordService.findRanksAndMentions(keyword);
    }

    @GetMapping("/keywords/{keyword}/related-articles")
    public List<RelatedNewsDto> getRelatedArticles(@PathVariable("keyword") String keyword) {
        return keywordService.findRelatedArticles(keyword);
    }
    @GetMapping("/analysis/users/heavy-user")
    public Page<CommentsUserDto> getHeavyUser() {
        return commentsService.findHeavyUser();
    }

    @GetMapping("/analysis/having-many-comments")
    public List<CommentsDto2> getNewsManyComments() {
        return commentsService.findNewsHasManyCommentsTopThree();
    }

    @GetMapping("/keywords/{keyword}/emoticon-analysis")
    public KeywordDto2 getKeywordEmoticon(@PathVariable("keyword") String keyword) {
        return keywordService.findKeywordEmoticon(keyword);
    }

    @GetMapping("/keywords/{keyword}/wordcloud")
    public List<RelKeywordDto> getRelkeywordByKeyword(@PathVariable("keyword") String keyword) {
        return relKeywordService.findRelkeywordByKeyword(keyword);
    }

    @GetMapping("/keywords/{keyword}/tags")
    public List<String> getRelatedKeyword(@PathVariable("keyword") String keyword) {
        return relKeywordService.findRelatedKeyword(keyword);
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
