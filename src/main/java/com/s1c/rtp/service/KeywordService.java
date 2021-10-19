package com.s1c.rtp.service;

import com.s1c.rtp.entity.news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1c.rtp.repository.*;
import com.s1c.rtp.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class KeywordService {

    @Autowired
    KeywordRepository keywordRepository;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    AgeRepository ageRepository;

    @Autowired
    NewsService newsService;

    @Autowired
    CommentsRepository commentsRepository;

    @Transactional
    public List<KeywordDto> returnBiggerThanRate(double rate){
        List<KeywordDto> listKeyword = keywordRepository.findAllKeyword();
        ArrayList<KeywordDto> listBiggerThanRate = new ArrayList<KeywordDto>();
        for(KeywordDto obj : listKeyword){
            if (obj.getRate() > rate) {
                listBiggerThanRate.add(obj);
            }
        }
        return listBiggerThanRate;
    }

    @Transactional
    public List<KeywordDto> returnBiggerThanCount(int count){
        List<KeywordDto> listKeyword = keywordRepository.findAllKeyword();
        ArrayList<KeywordDto> listBiggerThanCount = new ArrayList<KeywordDto>();
        for(KeywordDto obj : listKeyword){
            if (obj.getMentions() > count) {
                listBiggerThanCount.add(obj);
            }
        }
        return listBiggerThanCount;
    }

    @Transactional
    public List<RtpDto> returnRealTimePopularity() {
        Pageable pageableSize20 = PageRequest.of(0, 20);
        Page<KeywordDto> keywordDtos = keywordRepository.findTopKeyword(pageableSize20);
        List<RtpDto> rtpDtoList = new ArrayList<>();

        for(KeywordDto keywordDto : keywordDtos) {

            Page<String> pageBrefNews = newsService.retrieveBriefNewsByKeyword(keywordDto.getKeyword());
            HashMap<String, Double> genderRatio = newsService.retrieveGenderRatioByKeyword(keywordDto.getKeyword());
            HashMap<String, Double> ageRatio = newsService.retrieveAgeRatioByKeyword(keywordDto.getKeyword());

            List<String> brefList = pageBrefNews.getContent();
            String brefNews;
            if (brefList.size() == 0) {
                brefNews = "해당 키워드를 보여주기에 충분한 데이터가 모이지 않았습니다.";
            }
            else {
                brefNews =  brefList.get(0);
            }

            int keywordId = keywordDto.getKeywordId();
            String keyword = keywordDto.getKeyword();
            int rank = keywordDto.getRanks();
            double positive = keywordDto.getPositive();
            double negative = keywordDto.getNegative();

            HashMap<String, Double> sentiment = new HashMap<>();
            sentiment.put("positive", Math.round(positive*100)/100.0);
            sentiment.put("negative", Math.round(negative*100)/100.0);

            // 태그기능 준비안됨. 임의로 넣기 [관련키워드 기능이 완성되어야함]
            List<String> tags = new ArrayList<>();
            tags.add("태그기능");
            tags.add("할려면");
            tags.add("관련키워드 기능이");
            tags.add("만들어져야함.");
            RtpDto rtpDto = new RtpDto(keywordId, rank, keyword, brefNews,genderRatio, ageRatio, sentiment, tags);
            rtpDtoList.add(rtpDto);
        }
        return rtpDtoList;
    }

    @Transactional
    public HashMap<String, Integer> retrieveRanksAndMentions(String keyword) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        String key = keywordRepository.findKeywordByKeyword(keyword);
        KeywordDto searchedKeywordDTO = keywordRepository.findKeywordDTOByKeyword(key);

        int rank = searchedKeywordDTO.getRanks();
        int metions = searchedKeywordDTO.getMentions();

        hashMap.put("Rank", rank);
        hashMap.put("Mentions", metions);

        return hashMap;
    }

    @Transactional
    public List<RelatedNewsDto> retrieveRelatedArticles(String keyword) {

        Pageable pageableSize3 = PageRequest.of(0, 3);
        Page<Integer> newsIdDtos =newsRepository.findNewsIdByKeyword2(keyword, pageableSize3);

        List<RelatedNewsDto> relatedNewsDtoList = new ArrayList<>();

        for(int newsId : newsIdDtos){
            news news = newsRepository.findnewsByNewsId(newsId);
            String title = news.getTitle();
            String url = news.getUrl();
            int commentsNumber = commentsRepository.findCommentsNumberByNewsId(news.getNewsId());

            RelatedNewsDto relatedNewsDto = new RelatedNewsDto(title, url, commentsNumber);
            relatedNewsDtoList.add(relatedNewsDto);
        }

        return relatedNewsDtoList;
    }



}
