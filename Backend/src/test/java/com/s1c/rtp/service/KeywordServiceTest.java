package com.s1c.rtp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class KeywordServiceTest {

    @Autowired
    KeywordService keywordService;

    @Test
    public void test() {
        keywordService.findRealTimePopularity();

    }

}