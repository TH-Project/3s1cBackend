package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class AgeDto2 {

    private double avg_tens;
    private double avg_twenties;
    private double avg_thirties;
    private double avg_fourties;
    private double avg_fifties;
    private double avg_sixties;

    public AgeDto2(double avg_tens, double avg_twenties, double avg_thirties, double avg_fourties, double avg_fifties, double avg_sixties){
        this.avg_tens = avg_tens;
        this.avg_twenties = avg_twenties;
        this.avg_thirties = avg_thirties;
        this.avg_fourties = avg_fourties;
        this.avg_fifties = avg_fifties;
        this.avg_sixties = avg_sixties;
    }
}
