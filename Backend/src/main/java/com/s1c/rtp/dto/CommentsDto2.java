package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CommentsDto2 {


    private int newsId;
    private Long numOfComments;
    private String title;

    public CommentsDto2(int newsId, Long numOfComments, String title){
        this.newsId = newsId;
        this.numOfComments = numOfComments;
        this.title = title;
    }
}
