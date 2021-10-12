package com.s1c.rtp.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class TimeCommentsDto {

    private int commentsId;
    private Date date;
    private int time;

    public TimeCommentsDto(int commentsId, Date date){
        this.commentsId = commentsId;
        this.date = date;

        SimpleDateFormat time_format = new SimpleDateFormat("HH");
        this.time = Integer.parseInt(time_format.format(date));

    }
}
