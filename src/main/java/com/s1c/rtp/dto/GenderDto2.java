package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class GenderDto2 {

    private double avg_male;
    private double avg_female;

    public GenderDto2(double avg_male, double avg_female){
        this.avg_male = avg_male;
        this.avg_female = avg_female;
    }
}
