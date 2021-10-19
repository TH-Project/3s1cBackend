package com.s1c.rtp.service;

import com.s1c.rtp.dto.AgeDto;
import com.s1c.rtp.dto.GenderDto;
import com.s1c.rtp.dto.GroupByDto;
import com.s1c.rtp.dto.NewsDto;
import com.s1c.rtp.repository.AgeRepository;
import com.s1c.rtp.repository.GenderRepository;
import com.s1c.rtp.repository.KeywordRepository;
import com.s1c.rtp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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

    @Transactional
    public Page<String> retrieveBriefNewsByKeyword(String keyword) {

        String key = keywordRepository.findKeywordByKeyword(keyword);
        Pageable pageable = PageRequest.of(0, 1);

        return newsRepository.findBriefArticleByKeyword(key, pageable);
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


}
