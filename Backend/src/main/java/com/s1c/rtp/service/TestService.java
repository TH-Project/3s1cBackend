package com.s1c.rtp.service;

import com.s1c.rtp.dto.Test2dto;
import com.s1c.rtp.dto.Test3dto;
import com.s1c.rtp.dto.Test4Dto;
import com.s1c.rtp.entity.testentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1c.rtp.repository.TestRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Transactional
    public List<testentity> getAllTestList() {
        return testRepository.findAll();
    }


    @Transactional
    public List<Test2dto> findAllTest2dtoList() {

        int id1 = 1;
        String keyword1 = "COVID19";
        HashMap<String, Double> age1 = new HashMap<String, Double>();
        HashMap<String, Double> gender1 = new HashMap<String, Double>();
        HashMap<String, Double> sentiment1 = new HashMap<String, Double>();
        List<String> tag1 = new ArrayList<>();
        age1.put("10", 0.05);
        age1.put("20", 0.05);
        age1.put("30", 0.2);
        age1.put("40", 0.4);
        age1.put("50", 0.2);
        age1.put("60", 0.1);
        gender1.put("male", 0.7);
        gender1.put("female", 0.3);
        sentiment1.put("positive", 0.2);
        sentiment1.put("negative", 0.8);
        String summary1 = "이번주 코로나19 확진자가 지난주에= 비해 크게 증가하여 정부가 강력하고 효과적인 방역대책을 고심하고 있다.";
        tag1.add("꾸준한");
        tag1.add("중년층");
        tag1.add("자투리시간");
        tag1.add("비판적");

        int id2 = 2;
        String keyword2 = "정치보복";
        HashMap<String, Double> age2 = new HashMap<String, Double>();
        HashMap<String, Double> gender2 = new HashMap<String, Double>();
        HashMap<String, Double> sentiment2 = new HashMap<String, Double>();
        List<String> tag2 = new ArrayList<>();
        age2.put("10", 0.05);
        age2.put("20", 0.2);
        age2.put("30", 0.05);
        age2.put("40", 0.2);
        age2.put("50", 0.4);
        age2.put("60", 0.1);
        gender2.put("male", 0.9);
        gender2.put("female", 0.1);
        sentiment2.put("positive", 0.1);
        sentiment2.put("negative", 0.9);
        String summary2 = "이번 주 대선과 관련해서 정치보복 수사라는 의혹이 제기되고 있다";
        tag2.add("정치");
        tag2.add("여당");
        tag2.add("야당");
        tag2.add("비판적");

        int id3 = 3;
        String keyword3 = "대선";
        HashMap<String, Double> age3 = new HashMap<String, Double>();
        HashMap<String, Double> gender3 = new HashMap<String, Double>();
        HashMap<String, Double> sentiment3 = new HashMap<String, Double>();
        List<String> tag3 = new ArrayList<>();
        age3.put("10", 0.08);
        age3.put("20", 0.22);
        age3.put("30", 0.05);
        age3.put("40", 0.4);
        age3.put("50", 0.2);
        age3.put("60", 0.1);
        gender3.put("male", 0.5);
        gender3.put("female", 0.5);
        sentiment3.put("positive", 0.3);
        sentiment3.put("negative", 0.7);
        String summary3 = "대통령 선거가 4개월 앞으로 다가와 치열한 경선이 진행중이다.";
        tag3.add("대통령");
        tag3.add("대선");
        tag3.add("민주주의");
        tag3.add("토론");

        int id4 = 4;
        String keyword4 = "백신";
        HashMap<String, Double> age4 = new HashMap<String, Double>();
        HashMap<String, Double> gender4 = new HashMap<String, Double>();
        HashMap<String, Double> sentiment4 = new HashMap<String, Double>();
        List<String> tag4 = new ArrayList<>();
        age4.put("10", 0.15);
        age4.put("20", 0.1);
        age4.put("30", 0.15);
        age4.put("40", 0.35);
        age4.put("50", 0.1);
        age4.put("60", 0.15);
        gender4.put("male", 0.6);
        gender4.put("female", 0.4);
        sentiment4.put("positive", 0.6);
        sentiment4.put("negative", 0.4);
        String summary4 = "1차 백신접종률이 70%를 넘음에 따라 대한민국의 COVID 백신 접종률이 세계 60위를 기록하였다.";
        tag4.add("백신");
        tag4.add("코로나");
        tag4.add("예방접종");
        tag4.add("부작용");

        int id5 = 5;
        String keyword5 = "단풍";
        HashMap<String, Double> age5 = new HashMap<String, Double>();
        HashMap<String, Double> gender5 = new HashMap<String, Double>();
        HashMap<String, Double> sentiment5 = new HashMap<String, Double>();
        List<String> tag5 = new ArrayList<>();
        age5.put("10", 0.1);
        age5.put("20", 0.15);
        age5.put("30", 0.35);
        age5.put("40", 0.15);
        age5.put("50", 0.1);
        age5.put("60", 0.15);
        gender5.put("male", 0.3);
        gender5.put("female", 0.7);
        sentiment5.put("positive", 0.8);
        sentiment5.put("negative", 0.2);
        String summary5 = "가을을 맞이하여 수락산에 단풍이 피었으며 단풍을 구경하기위해 나들이객이 많이 방문하였다.";
        tag5.add("가을");
        tag5.add("단풍");
        tag5.add("관광");
        tag5.add("사회적거리두기");

        int id6 = 6;
        String keyword6 = "메타버스";
        HashMap<String, Double> age6 = new HashMap<String, Double>();
        HashMap<String, Double> gender6 = new HashMap<String, Double>();
        HashMap<String, Double> sentiment6 = new HashMap<String, Double>();
        List<String> tag6 = new ArrayList<>();
        age6.put("10", 0.35);
        age6.put("20", 0.15);
        age6.put("30", 0.1);
        age6.put("40", 0.15);
        age6.put("50", 0.15);
        age6.put("60", 0.1);
        gender6.put("male", 0.9);
        gender6.put("female", 0.1);
        sentiment6.put("positive", 0.9);
        sentiment6.put("negative", 0.1);
        String summary6 = "국내 첫 메타버스 ETF가 상장예고하였으며 많은 시장관계자의 주목을 받고 있다.";
        tag6.add("메타버스");
        tag6.add("네이버");
        tag6.add("하이브");
        tag6.add("ETF");

        Test2dto test1 = new Test2dto(id1, keyword1, age1, gender1, sentiment1, summary1, tag1);
        Test2dto test2 = new Test2dto(id2, keyword2, age2, gender2, sentiment2, summary2, tag2);
        Test2dto test3 = new Test2dto(id3, keyword3, age3, gender3, sentiment3, summary3, tag3);
        Test2dto test4 = new Test2dto(id4, keyword4, age4, gender4, sentiment4, summary4, tag4);
        Test2dto test5 = new Test2dto(id5, keyword5, age5, gender5, sentiment5, summary5, tag5);
        Test2dto test6 = new Test2dto(id6, keyword6, age6, gender6, sentiment6, summary6, tag6);

        List<Test2dto> test2dtoList = new ArrayList<>();
        test2dtoList.add(test1);
        test2dtoList.add(test2);
        test2dtoList.add(test3);
        test2dtoList.add(test4);
        test2dtoList.add(test5);
        test2dtoList.add(test6);

        return test2dtoList;
    }

    @Transactional
    public Test3dto findAllTest3dtoList() {

        int comment1 = 275631;
        int article1 = 1121;
        HashMap<String, Double> day0 = new HashMap<>();
        HashMap<String, Double> day1 = new HashMap<>();
        HashMap<String, Double> day2 = new HashMap<>();

        HashMap<String, HashMap<String, Double>> sentiment = new HashMap<>();
        day0.put("positive", 0.13);
        day0.put("negative", 0.87);
        day1.put("positive", 0.20);
        day1.put("negative", 0.80);
        day2.put("positive", 0.15);
        day2.put("negative", 0.85);

        sentiment.put("day0", day0);
        sentiment.put("day1", day1);
        sentiment.put("day2", day2);

        HashMap<String, HashMap<String, Integer>> ranking = new HashMap<>();

        HashMap<String, Integer> rank1 = new HashMap<>();
        HashMap<String, Integer> rank2 = new HashMap<>();
        HashMap<String, Integer> rank3 = new HashMap<>();

        rank1.put("코로나", 33286);
        rank2.put("북한", 12562);
        rank3.put("대통령", 6189);

        ranking.put("1", rank1);
        ranking.put("2", rank2);
        ranking.put("3", rank3);


        Test3dto test3dto = new Test3dto(comment1, article1, sentiment, ranking);

        return test3dto;
    }

    @Transactional
    public List<Test4Dto> findAllTest4dtoList() {

        HashMap<String, Integer> rank1 = new HashMap<String, Integer>();
        HashMap<String, Integer> rank2 = new HashMap<String, Integer>();
        HashMap<String, Integer> rank3 = new HashMap<String, Integer>();

        rank1.put("윤석열", 15);
        rank1.put("후보", 14);
        rank1.put("국민", 13);
        rank1.put("조직", 12);
        rank1.put("대장동", 11);
        rank1.put("대통령", 10);
        rank1.put("검사", 9);
        rank1.put("날씨", 8);
        rank1.put("비리", 7);
        rank1.put("대한민국", 6);
        rank1.put("양심", 5);
        rank1.put("개인", 4);
        rank1.put("정검", 3);
        rank1.put("수석", 2);
        rank1.put("공권력", 1);

        rank2.put("국민", 15);
        rank2.put("후보", 14);
        rank2.put("윤석열", 13);
        rank2.put("대장동", 12);
        rank2.put("검사", 11);
        rank2.put("홍준표", 10);
        rank2.put("감옥", 9);
        rank2.put("대통령", 8);
        rank2.put("조사", 7);
        rank2.put("경선", 6);
        rank2.put("장모", 5);
        rank2.put("정검", 4);
        rank2.put("검사", 3);
        rank2.put("공권력", 2);
        rank2.put("중국", 1);

        rank3.put("후보", 15);
        rank3.put("대장동", 14);
        rank3.put("윤석열", 13);
        rank3.put("감옥", 12);
        rank3.put("검사", 11);
        rank3.put("이재명", 10);
        rank3.put("조사", 9);
        rank3.put("외교", 8);
        rank3.put("탈원전", 7);
        rank3.put("검사", 6);
        rank3.put("대통령", 5);
        rank3.put("국민", 4);
        rank3.put("공권력", 3);
        rank3.put("민주", 2);
        rank3.put("수석", 1);

        Test4Dto day1 = new Test4Dto(1, rank1);
        Test4Dto day2 = new Test4Dto(2, rank2);
        Test4Dto day3 = new Test4Dto(3, rank3);

        List<Test4Dto> list = new ArrayList<>();
        list.add(day1);
        list.add(day2);
        list.add(day3);

        return list;
    }


}
