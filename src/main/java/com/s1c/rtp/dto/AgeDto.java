package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class AgeDto {

    private int ageId;
    private int newsId;
    private double tens;
    private double twenties;
    private double thirties;
    private double fourties;
    private double fifties;
    private double sixties;

    public AgeDto(int ageId, int News_Id, double tens, double twenties, double thirties, double fourties, double fifties, double sixties){
        this.ageId = ageId;
        newsId = News_Id;
        this.tens = tens;
        this.twenties = twenties;
        this.thirties = thirties;
        this.fourties = fourties;
        this.fifties = fifties;
        this.sixties = sixties;
    }

}
