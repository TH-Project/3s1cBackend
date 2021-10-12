package com.s1c.rtp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1c.rtp.repository.*;
import com.s1c.rtp.dto.*;
import com.s1c.rtp.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    WholeDataRepository wholeDataRepository;

    @Transactional
    public GroupByDto returnNumOfWritersNComments(){
        Long numOfComments = wholeDataRepository.numOfCommentsData();
        Long numOfWriters = commentsRepository.returnNumOfWriters();

        return new GroupByDto(numOfComments, numOfWriters);
    }

}