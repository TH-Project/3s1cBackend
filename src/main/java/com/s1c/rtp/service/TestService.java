package com.s1c.rtp.service;

import com.s1c.rtp.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1c.rtp.repository.TestRepository;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Transactional
    public List<TestEntity> getAllTestList() {
        return testRepository.findAll();
    }
}
