package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class NewsDto3 {

    private int like;
    private int sad;
    private int angry;
    private int warm;

    public NewsDto3(int like, int sad, int angry, int warm){
        this.like = like;
        this.sad = sad;
        this.angry = angry;
        this.warm = warm;
    }
}
