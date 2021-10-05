package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentsDto {

    private int commentsId;
    private int newsId;
    private String contents;
    private String writer;
    private int recommended;
    private int unrecommended;
    private Timestamp date;
    private String news_title;

    public CommentsDto(int commentsId, int News_Comments, String contents, String writer, int recommended, int unrecommended, Timestamp date){
        this.commentsId = commentsId;
        newsId = News_Comments;
        this.contents = contents;
        this.writer = writer;
        this.recommended = recommended;
        this.unrecommended = unrecommended;
        this.date = date;
    }

    public CommentsDto(int commentsId, String news_title, String contents, String writer){
        this.commentsId = commentsId;
        this.news_title = news_title;
        this.contents = contents;
        this.writer = writer;
    }
}
