package com.s1c.rtp.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"today","today_comments" ,"today_news" ,"week_comments" ,"week_news" ,"hist_comments" ,"hist_news"})
public class WholeDataNum {

    @Id @GeneratedValue
    private Timestamp today;

    private Long today_comments;
    private Long today_news;

    private Long week_comments;
    private Long week_news;

    private Long hist_comments;
    private Long hist_news;

    public WholeDataNum(Timestamp today, Long today_comments, Long today_news, Long week_comments, Long week_news, Long hist_comments, Long hist_news){
        this.today = today;
        this.today_comments = today_comments;
        this.today_news = today_news;
        this.week_comments = week_comments;
        this.week_news = week_news;
        this.hist_comments = hist_comments;
        this.hist_news = hist_news;
    }
}
