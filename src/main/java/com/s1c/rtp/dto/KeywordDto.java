package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class KeywordDto {

    private int keywordId;
    private String keyword;
    private double positive;
    private double negative;
    private int ranks;
    private int mentions;

    private double rate = negative / positive;

    public KeywordDto(int keywordId, String keyword, double positive, double negative, int ranks, int mentions){
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.positive = positive;
        this.negative = negative;
        this.ranks = ranks;
        this.mentions = mentions;
    }

    public KeywordDto(String keyword, double positive, double negative){
        this.keyword = keyword;
        this.positive = positive;
        this.negative = negative;
        this.rate = negative/positive;
    }
}
