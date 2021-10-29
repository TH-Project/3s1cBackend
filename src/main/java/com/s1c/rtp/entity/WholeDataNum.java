package com.s1c.rtp.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"today_comments" ,"today_news" ,"hist_comments" ,"hist_news","hist_writers","today_writers"})
public class WholeDataNum {

    @Id @GeneratedValue
    private int id;

    private Long today_comments;
    private Long today_news;
    private Long today_writers;

    private Long hist_writers;
    private Long hist_comments;
    private Long hist_news;

    public WholeDataNum(int id, Long today_comments, Long today_news, Long today_writers, Long hist_comments, Long hist_news, Long hist_writers){
        this.id = id;
        this.today_comments = today_comments;
        this.today_news = today_news;
        this.today_writers = today_writers;
        this.hist_comments = hist_comments;
        this.hist_news = hist_news;
        this.hist_writers = hist_writers;
    }
}
