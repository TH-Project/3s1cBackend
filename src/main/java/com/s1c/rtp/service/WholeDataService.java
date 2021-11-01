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
    public WholeDataDto2 findNumOfWholeData(){
        return wholeDataRepository.returnWholeDataNum();
    }

    @Transactional
    public Long findNumOfComments(){
        return wholeDataRepository.numOfCommentsData();
    }

    @Transactional
    public Long findNumOfNews(){
        return wholeDataRepository.numOfNewsData();
    }
}
