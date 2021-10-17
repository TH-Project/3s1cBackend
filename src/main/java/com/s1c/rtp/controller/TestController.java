package com.s1c.rtp.controller;


import java.util.List;

import com.s1c.rtp.dto.NewsDto;
import com.s1c.rtp.dto.Test2dto;
import com.s1c.rtp.dto.Test3dto;
import com.s1c.rtp.entity.TestEntity;
import com.s1c.rtp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.s1c.rtp.service.TestService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    TestService testService;



    @GetMapping("/test")
    public List<TestEntity> retriveTestPopularity() {
        return  testService.getAllTestList();
    }


    // 실제 데이터로 대체
    //   @GetMapping("/real-time-popularity")
    //   public List<Test2dto> retriveAllPopularity() {
    //       return  testService.getAllTest2dtoList();
    //   }

    @GetMapping("/real-time-popularity/test")
    public String returnTestString() {
        String test = "[{\"id\":1,\"keyword\":\"COVID19\",\"age\":{\"60\":0.1,\"50\":0.2,\"40\":0.4,\"30\":0.2,\"20\":0.05,\"10\":0.05},\"gender\":{\"female\":0.3,\"male\":0.7},\"sentiment\":{\"negative\":0.8,\"positive\":0.2},\"summary\":\"이번주 코로나19 확진자가 지난주에= 비해 크게 증가하여 정부가 강력하고 효과적인 방역대책을 고심하고 있다.\",\"tag\":[\"꾸준한\",\"중년층\",\"자투리시간\",\"비판적\"]},{\"id\":2,\"keyword\":\"정치보복\",\"age\":{\"60\":0.1,\"50\":0.4,\"40\":0.2,\"30\":0.05,\"20\":0.2,\"10\":0.05},\"gender\":{\"female\":0.1,\"male\":0.9},\"sentiment\":{\"negative\":0.9,\"positive\":0.1},\"summary\":\"이번 주 대선과 관련해서 정치보복 수사라는 의혹이 제기되고 있다\",\"tag\":[\"정치\",\"여당\",\"야당\",\"비판적\"]},{\"id\":3,\"keyword\":\"대선\",\"age\":{\"60\":0.1,\"50\":0.2,\"40\":0.4,\"30\":0.05,\"20\":0.22,\"10\":0.08},\"gender\":{\"female\":0.5,\"male\":0.5},\"sentiment\":{\"negative\":0.7,\"positive\":0.3},\"summary\":\"대통령 선거가 4개월 앞으로 다가와 치열한 경선이 진행중이다.\",\"tag\":[\"대통령\",\"대선\",\"민주주의\",\"토론\"]},{\"id\":4,\"keyword\":\"백신\",\"age\":{\"60\":0.15,\"50\":0.1,\"40\":0.35,\"30\":0.15,\"20\":0.1,\"10\":0.15},\"gender\":{\"female\":0.4,\"male\":0.6},\"sentiment\":{\"negative\":0.4,\"positive\":0.6},\"summary\":\"1차 백신접종률이 70%를 넘음에 따라 대한민국의 COVID 백신 접종률이 세계 60위를 기록하였다.\",\"tag\":[\"백신\",\"코로나\",\"예방접종\",\"부작용\"]},{\"id\":5,\"keyword\":\"단풍\",\"age\":{\"60\":0.15,\"50\":0.1,\"40\":0.15,\"30\":0.35,\"20\":0.15,\"10\":0.1},\"gender\":{\"female\":0.7,\"male\":0.3},\"sentiment\":{\"negative\":0.2,\"positive\":0.8},\"summary\":\"가을을 맞이하여 수락산에 단풍이 피었으며 단풍을 구경하기위해 나들이객이 많이 방문하였다.\",\"tag\":[\"가을\",\"단풍\",\"관광\",\"사회적거리두기\"]},{\"id\":6,\"keyword\":\"메타버스\",\"age\":{\"60\":0.1,\"50\":0.15,\"40\":0.15,\"30\":0.1,\"20\":0.15,\"10\":0.35},\"gender\":{\"female\":0.1,\"male\":0.9},\"sentiment\":{\"negative\":0.1,\"positive\":0.9},\"summary\":\"국내 첫 메타버스 ETF가 상장예고하였으며 많은 시장관계자의 주목을 받고 있다.\",\"tag\":[\"메타버스\",\"네이버\",\"하이브\",\"ETF\"]}]";
        return test;
    }
    @GetMapping("/real-time-popularity/cumulative-statics")
    public Test3dto retriveAllCumulativeStatics() {
        return testService.getAllTest3dtoList();
    }

}