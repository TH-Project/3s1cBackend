package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class RelatedNewsDto {
    int id; // newsId가 아닌, 프론트엔드에서 구분을 위한 임시적 id
    int news_id;
    String newsTitle;
    private String url;
    int commentsNum;

    public RelatedNewsDto(int id, int news_id, String newsTitle, String url, int commentsNum) {
        this.id = id;
        this.news_id = news_id;
        this.newsTitle = newsTitle;
        this.url = url;
        this.commentsNum = commentsNum;
    }
}
