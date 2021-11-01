package com.s1c.rtp.service;

import com.s1c.rtp.repository.CommentsRepository;
import com.s1c.rtp.repository.RelKeywordRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class RelKeywordServiceTest {

    @Autowired
    RelKeywordService relKeywordService;

    @Autowired
    RelKeywordRepository relKeywordRepository;

    @Autowired
    CommentsRepository commentsRepository;


}