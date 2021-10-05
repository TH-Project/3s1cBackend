package com.s1c.rtp.service;

import com.s1c.rtp.dto.WholeDataDto;
import com.s1c.rtp.entity.WholeDataNum;
import com.s1c.rtp.repository.WholeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1c.rtp.repository.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WholeDataService {

    @Autowired
    WholeDataRepository wholeDataRepository;

    @Transactional
    public void updateWholeDataTable(){
        Long comments_today = wholeDataRepository.numOfCommentsData();
        Long news_today = wholeDataRepository.numOfNewsData();

        wholeDataRepository.updateNumOfComments(comments_today);
        wholeDataRepository.updateNumOfNews(news_today);

        wholeDataRepository.updateToday();
    }

    @Transactional
    public Long returnNumOfComments(){
        return wholeDataRepository.numOfCommentsData();
    }

    @Transactional
    public Long returnNumOfNews(){
        return wholeDataRepository.numOfNewsData();
    }
}
