package com.s1c.rtp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class Test2dto {
    String keyword;
    HashMap<String, Double> age;
    HashMap<String, Double> gender;
    HashMap<String, Double> sentiment;
    String summary;
    List<String> tag;

    public Test2dto(String keyword, HashMap<String, Double> age, HashMap<String, Double> gender, HashMap<String, Double> sentiment, String summary, List<String> tag) {
        this.keyword = keyword;
        this.age = age;
        this.gender = gender;
        this.sentiment = sentiment;
        this.summary = summary;
        this.tag = tag;
    }
}
