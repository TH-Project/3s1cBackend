package com.s1c.rtp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class Test3dto {

    int comments;
    int articles;
    HashMap<String, HashMap<String, Double>> sentiment;
    HashMap<String, HashMap<String, Integer>> ranking;

    public Test3dto(int comment1, int article1, HashMap<String, HashMap<String, Double>> sentiment, HashMap<String, HashMap<String, Integer>> ranking) {
        this.comments = comment1;
        this.articles = article1;
        this.sentiment = sentiment;
        this.ranking = ranking;
    }
}
