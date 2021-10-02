package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class GenderDto {

    private int genderId;
    private int newsId;
    private double male;
    private double female;

    public GenderDto(int genderId, int News_Gender, double male, double female){
        this.genderId = genderId;
        newsId = News_Gender;
        this.male = male;
        this.female = female;
    }
}
