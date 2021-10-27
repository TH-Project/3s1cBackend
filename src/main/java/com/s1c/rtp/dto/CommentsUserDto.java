package com.s1c.rtp.dto;

import lombok.Data;

@Data
public class CommentsUserDto {
    Long commentsNumber;
    String userName;
    int id;

    public CommentsUserDto(Long commentsNumber, String userName) {
        this.commentsNumber = commentsNumber;
        this.userName = userName;
    }
}
