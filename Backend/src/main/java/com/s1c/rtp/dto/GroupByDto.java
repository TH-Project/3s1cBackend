package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class GroupByDto {
    private Long wholeComments;
    private Long wholeWriters;

    public GroupByDto(Long wholeComments, Long wholeWriters){
        this.wholeComments = wholeComments;
        this.wholeWriters = wholeWriters;
    }
}
