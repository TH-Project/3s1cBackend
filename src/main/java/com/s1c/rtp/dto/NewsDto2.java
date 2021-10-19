package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NewsDto2 {

     int newsId;
     String title;
     String url;

    public NewsDto2(int newsId, String title, String url){
        this.newsId = newsId;
        this.title = title;
        this.url = url;
    }
}
