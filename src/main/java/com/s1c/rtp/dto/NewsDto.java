package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NewsDto {

    private int newsId;
    private String title;
    private String url;
    private Timestamp date;

    public NewsDto(int newsId, String title, String url, Timestamp date){
        this.newsId = newsId;
        this.title = title;
        this.url = url;
        this.date = date;
    }
}
