package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class KeywordDto2 {

    private String keyword;
    private int like;
    private int sad;
    private int angry;
    private int warm;

    public KeywordDto2(String keyword, int like, int sad, int angry, int warm){
        this.keyword = keyword;
        this.like = like;
        this.sad = sad;
        this.angry = angry;
        this.warm = warm;
    }
}
