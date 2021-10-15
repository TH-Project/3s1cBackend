package com.s1c.rtp.service;

import com.s1c.rtp.dto.GroupByDto;
import com.s1c.rtp.dto.NewsDto;
import com.s1c.rtp.repository.KeywordRepository;
import com.s1c.rtp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    KeywordRepository keywordRepository;

    @Transactional
    public Page<String> retrieveBriefNews(String keyword) {

        String key = keywordRepository.findKeywordByKeyword(keyword);
        Pageable pageable = PageRequest.of(0, 1);

        return newsRepository.findBriefArticleByKeyword(key, pageable);
    }


}
