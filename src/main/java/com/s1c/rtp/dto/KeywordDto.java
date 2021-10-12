package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class KeywordDto {

    private int keywordId;
    private String keyword;
    private double positive;
    private double negative;
    private int rank;
    private int mentions;

    public KeywordDto(int keywordId, String keyword, double positive, double negative, int rank, int mentions){
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.positive = positive;
        this.negative = negative;
        this.rank = rank;
        this.mentions = mentions;
    }
}
