package com.s1c.rtp.controller;

import java.util.HashMap;
import java.util.List;

import com.s1c.rtp.dto.*;
import com.s1c.rtp.repository.*;
import com.s1c.rtp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class KeywordController {

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

    @GetMapping("/keywords/{keyword}/ranks-mentions")
    public HashMap<String, Integer> getRanksAndMetions(@PathVariable("keyword") String keyword) {
        return keywordService.findRanksAndMentions(keyword);
    }

    @GetMapping("/keywords/{keyword}/related-articles")
    public List<RelatedNewsDto> getRelatedArticles(@PathVariable("keyword") String keyword) {
        return keywordService.findRelatedArticles(keyword);
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

    @GetMapping("/keywords/{keyword}/sentiment")
    public HashMap<String, Double> getSentiment(@PathVariable("keyword") String keyword) {
        return keywordService.findSentimentByKeyword(keyword);
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
}
