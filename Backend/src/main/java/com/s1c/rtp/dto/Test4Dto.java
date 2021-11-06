package com.s1c.rtp.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class Test4Dto {
    int day;
    HashMap<String, Integer> rank = new HashMap<String, Integer>();

    public Test4Dto(int day, HashMap<String, Integer> rank) {
        this.day = day;
        this.rank = rank;
    }
}
