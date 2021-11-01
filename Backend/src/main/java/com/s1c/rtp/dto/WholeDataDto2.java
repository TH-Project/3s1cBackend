package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class WholeDataDto2 {
    private Long today_comments;
    private Long today_news;
    private Long today_writers;

    private Long hist_writers;
    private Long hist_comments;
    private Long hist_news;

    public WholeDataDto2(Long today_comments, Long today_news, Long today_writers, Long hist_comments, Long hist_news, Long hist_writers){
        this.today_comments = today_comments;
        this.today_news = today_news;
        this.today_writers = today_writers;
        this.hist_comments = hist_comments;
        this.hist_news = hist_news;
        this.hist_writers = hist_writers;
    }
}
