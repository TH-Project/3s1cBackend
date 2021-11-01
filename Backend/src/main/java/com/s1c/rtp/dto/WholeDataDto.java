package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class WholeDataDto {

    private Timestamp today;

    private Long today_comments;
    private Long today_news;

    private Long week_comments;
    private Long week_news;

    private Long hist_comments;
    private Long hist_news;

    public WholeDataDto(Timestamp today, Long today_comments, Long today_news, Long week_comments, Long week_news, Long hist_comments, Long hist_news){
        this.today = today;
        this.today_comments = today_comments;
        this.today_news = today_news;
        this.week_comments = week_comments;
        this.week_news = week_news;
        this.hist_comments = hist_comments;
        this.hist_news = hist_news;
    }
}
