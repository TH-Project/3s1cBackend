package com.s1c.rtp.service;

import com.s1c.rtp.dto.GenderDto;
import com.s1c.rtp.dto.GroupByDto;
import com.s1c.rtp.dto.NewsDto;
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

        int maleSum = 0;
        int femaleSum = 0;

        for (int i : searchedNewsId) {
            GenderDto genderDto = genderRepository.findGenderDtoByNewsId(i);
            maleSum += genderDto.getMale();
            femaleSum += genderDto.getFemale();
        }

        double avgMale = maleSum / searchedNewsId.size();
        double avgFemale = femaleSum / searchedNewsId.size();

        hashMap.put("male", avgMale);
        hashMap.put("female", avgFemale);

        return hashMap;
    }




}
