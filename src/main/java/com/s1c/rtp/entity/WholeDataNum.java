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

    private int today_comments;
    private int today_news;

    private int week_comments;
    private int week_news;

    private int hist_comments;
    private int hist_news;

    public WholeDataNum(Timestamp today, int today_comments, int today_news, int week_comments, int week_news, int hist_comments, int hist_news){
        this.today = today;
        this.today_comments = today_comments;
        this.today_news = today_news;
        this.week_comments = week_comments;
        this.week_news = week_news;
        this.hist_comments = hist_comments;
        this.hist_news = hist_news;
    }
}
