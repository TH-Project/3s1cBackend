package com.s1c.rtp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentsDto3 {
    private long numOfComments;
    private int newsId;

    public CommentsDto3(long numOfComments, int newsId) {
        this.numOfComments = numOfComments;
        this.newsId = newsId;
    }
}