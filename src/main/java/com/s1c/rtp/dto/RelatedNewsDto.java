package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class RelatedNewsDto {
    String newsTitle;
    private String url;
    int commentsNum;

    public RelatedNewsDto(String newsTitle, String url, int commentsNum) {
        this.newsTitle = newsTitle;
        this.url = url;
        this.commentsNum = commentsNum;
    }
}
