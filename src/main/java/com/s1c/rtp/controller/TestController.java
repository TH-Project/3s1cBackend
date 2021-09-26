package com.s1c.rtp.controller;


import java.util.List;

import com.s1c.rtp.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.s1c.rtp.service.TestService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<TestEntity> retriveAllPopularity() {
        return  testService.getAllTestList();
    }
}