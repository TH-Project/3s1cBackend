package com.s1c.rtp.service;


import com.s1c.rtp.dto.*;
import com.s1c.rtp.repository.WholeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WholeDataService {

    @Autowired
    WholeDataRepository wholeDataRepository;

    @Transactional
    public WholeDataDto2 returnNumOfWholeData(){
        return wholeDataRepository.returnWholeDataNum();
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
