package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class SentimentDto {
    double negative;
    double positive;

    public SentimentDto(double negative, double positive) {
        this.negative = negative;
        this.positive = positive;
    }
}
