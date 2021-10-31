package com.s1c.rtp.service;

import com.s1c.rtp.dto.*;
import com.s1c.rtp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    KeywordRepository keywordRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    AgeRepository ageRepository;

    @Autowired
    RelKeywordService relKeywordService;

    @Autowired
    CommentsRepository commentsRepository;

    @Transactional
    public Page<String> retrieveBriefNewsByKeyword(String keyword) {

        String key = keywordRepository.findKeywordByKeyword(keyword);
        Pageable pageable = PageRequest.of(0, 1);

        Page<String> brifNews = newsRepository.findBriefArticleByKeyword(key, pageable);

        if (brifNews.getTotalElements() == 0){ // news
            int newsId = retrieveNewsIdByKeyword(keyword);

            if(newsId ==-99){
                return brifNews;
            }
            Page<String> brifNews2 = retrieveNewsByNewsId(newsId);
            return  brifNews2;
        }

        return brifNews;
    }

    @Transactional
    public int retrieveNewsIdByKeyword(String keyword) {
        Pageable pageable = PageRequest.of(0, 1);
        Page<CommentsDto3> list = commentsRepository.getCountByKeyword(keyword, pageable);

        int newsId =-99;
        for(CommentsDto3 dto : list) {
            newsId =dto.getNewsId();
        }
        return newsId;
    }

    @Transactional
    public Page<String> retrieveNewsByNewsId(int newsId) {
        Pageable pageable = PageRequest.of(0, 1);
        Page<String> brifNews2 = newsRepository.findBriefArticleByNewsId(newsId, pageable);

        for(Iterator<String> it = brifNews2.iterator(); it.hasNext() ;) {
            String string = it.next();
            if(string.equals("")) {
                it.remove();;
            }
        }

        return brifNews2;
    }

    @Transactional
    public List<String> retrieveNewsIdByKeyword2(String keyword) { // For testing Api
        Page<String> list = retrieveNewsByNewsId(retrieveNewsIdByKeyword(keyword));
        List<String> newlist = list.getContent();
        return newlist;
    }


    @Transactional
    public HashMap<String, Double> retrieveGenderRatioByKeyword(String keyword) {

        HashMap<String, Double> hashMap = new HashMap<>();
        String key = keywordRepository.findKeywordByKeyword(keyword);
        List<Integer> searchedNewsId = newsRepository.findNewsIdByKeyword(key);

        if(searchedNewsId.size() == 0) {
            hashMap.put("male", 0.00);
            hashMap.put("female", 0.00);
            return hashMap;
        }

        double maleSum = 0;
        double femaleSum = 0;

        for (int i : searchedNewsId) {
            GenderDto genderDto = genderRepository.findGenderDtoByNewsId(i);
            maleSum += genderDto.getMale();
            femaleSum += genderDto.getFemale();
        }

        double avgMale =  (maleSum / searchedNewsId.size())/100;
        double avgFemale = (femaleSum / searchedNewsId.size())/100;

        hashMap.put("male", Math.round(avgMale*100)/100.0);
        hashMap.put("female", Math.round(avgFemale*100)/100.0);

        return hashMap;
    }

    @Transactional
    public HashMap<String, Double> retrieveAgeRatioByKeyword(String keyword) {

        HashMap<String, Double> hashMap = new HashMap<>();
        String key = keywordRepository.findKeywordByKeyword(keyword);
        List<Integer> searchedNewsId = newsRepository.findNewsIdByKeyword(key);

        if(searchedNewsId.size() == 0) {
            hashMap.put("10", 0.00);
            hashMap.put("20", 0.00);
            hashMap.put("30", 0.00);
            hashMap.put("40", 0.00);
            hashMap.put("50", 0.00);
            hashMap.put("60", 0.00);
            return hashMap;
        }

        double tensSum = 0;
        double twentiesSum = 0;
        double thirtiesSum = 0;
        double fourtiesSum = 0;
        double fiftiesSum = 0;
        double sixtiesSum = 0 ;

        for (int i : searchedNewsId) {
            AgeDto ageDto = ageRepository.findAgeDtoByNewsId(i);
            tensSum += ageDto.getTens();
            twentiesSum += ageDto.getTwenties();
            thirtiesSum += ageDto.getThirties();
            fourtiesSum += ageDto.getFourties();
            fiftiesSum += ageDto.getFifties();
            sixtiesSum += ageDto.getSixties();
        }

        double avgTens = (tensSum / searchedNewsId.size())/100;
        double avgTwenties = (twentiesSum / searchedNewsId.size())/100;
        double avgFhirties = (thirtiesSum / searchedNewsId.size())/100;
        double avgFourties = (fourtiesSum / searchedNewsId.size())/100;
        double avgFifties = (fiftiesSum / searchedNewsId.size())/100;
        double avgSixteis = (sixtiesSum / searchedNewsId.size())/100;

        hashMap.put("10", Math.round(avgTens*100)/100.0);
        hashMap.put("20", Math.round(avgTwenties*100)/100.0);
        hashMap.put("30", Math.round(avgFhirties*100)/100.0);
        hashMap.put("40", Math.round(avgFourties*100)/100.0);
        hashMap.put("50", Math.round(avgFifties*100)/100.0);
        hashMap.put("60", Math.round(avgSixteis*100)/100.0);

        return hashMap;
    }

    @Transactional
    public GenderAgeDto returnGenderAgeStatistics() {
        List<Integer> newsIdList = newsRepository.findAllNewsId();
        int newsIdSize = newsIdList.size();
        double avg_male = 0;
        double avg_female = 0;
        double avg_tens = 0;
        double avg_twenties = 0;
        double avg_thirties = 0;
        double avg_fourties = 0;
        double avg_fifties = 0;
        double avg_sixties = 0;

        for (Integer newsId : newsIdList) {
            GenderDto2 tempGender = genderRepository.findGenderStatistics(newsId);
            AgeDto2 tempAge = ageRepository.findAgeStatistics(newsId);

            avg_male += tempGender.getAvg_male();
            avg_female += tempGender.getAvg_female();
            avg_tens += tempAge.getAvg_tens();
            avg_twenties += tempAge.getAvg_twenties();
            avg_thirties += tempAge.getAvg_thirties();
            avg_fourties += tempAge.getAvg_fourties();
            avg_fifties += tempAge.getAvg_fifties();
            avg_sixties += tempAge.getAvg_sixties();
        }

        avg_male = avg_male / newsIdSize;
        avg_female = avg_female / newsIdSize;
        avg_tens = avg_tens / newsIdSize;
        avg_twenties = avg_twenties / newsIdSize;
        avg_thirties = avg_thirties / newsIdSize;
        avg_fourties = avg_fourties / newsIdSize;
        avg_fifties = avg_fifties / newsIdSize;
        avg_sixties = avg_sixties / newsIdSize;

        return new GenderAgeDto(avg_male, avg_female, avg_tens, avg_twenties, avg_thirties, avg_fourties, avg_fifties, avg_sixties);
    }


}
