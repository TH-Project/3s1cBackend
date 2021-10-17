package com.s1c.rtp.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class RtpDto {
    private int keywordId;
    private int ranks;
    private String keyword;
    private String brifNews;
    private HashMap<String , Double> genderRatio;
    private HashMap<String , Double> ageRatio;
    private HashMap<String , Double> sentiment;
    private List<String> tag; // 태그기능 준비안됨. 임의로 넣기 [관련키워드 기능이 완성되어야함]

    // private int mentions;


    public RtpDto(int keywordId, int ranks, String keyword, String brifNews, HashMap<String, Double> genderRatio, HashMap<String, Double> ageRatio, HashMap<String, Double> sentiment, List<String> tag) {
        this.keywordId = keywordId;
        this.ranks = ranks;
        this.keyword = keyword;
        this.brifNews = brifNews;
        this.genderRatio = genderRatio;
        this.ageRatio = ageRatio;
        this.sentiment = sentiment;
        this.tag = tag;
    }
}
