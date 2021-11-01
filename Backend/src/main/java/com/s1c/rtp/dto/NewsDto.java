package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NewsDto {

    private int newsId;
    private String title;
    private String url;
    private Timestamp date;
    private String brief_article;

    public NewsDto(int newsId, String title, String url, Timestamp date, String brief_article){
        this.newsId = newsId;
        this.title = title;
        this.url = url;
        this.date = date;
        this.brief_article = brief_article;
    }
}
