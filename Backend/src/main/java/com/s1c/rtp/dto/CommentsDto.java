package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CommentsDto {

    private int commentsId;
    private int newsId;
    private String contents;
    private String writer;
    private int recommended;
    private int unrecommended;
    private Date date;
    private String news_title;

    private int time;

    public CommentsDto(int commentsId, int News_Comments, String contents, String writer, int recommended, int unrecommended, Date date){
        this.commentsId = commentsId;
        this.newsId = News_Comments;
        this.contents = contents;
        this.writer = writer;
        this.recommended = recommended;
        this.unrecommended = unrecommended;
        this.date = date;

        SimpleDateFormat time_format = new SimpleDateFormat("HH");
        this.time = Integer.parseInt(time_format.format(date));
    }

    public CommentsDto(int commentsId, String news_title, String contents, String writer, Date date){
        this.commentsId = commentsId;
        this.news_title = news_title;
        this.contents = contents;
        this.writer = writer;
        this.date = date;
    }
}
