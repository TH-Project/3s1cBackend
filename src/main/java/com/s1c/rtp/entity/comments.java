package com.s1c.rtp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"commentsId", "contents", "writer", "recommended", "unrecommended", "date"})
public class comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comments_id")
    private int commentsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    @JsonIgnore
    private news news_comments;

    private String contents;
    private String writer;
    private int recommended;
    private int unrecommended;
    private Timestamp date;

    public comments(int commentsId, String contents, String writer, int recommended, int unrecommended, Timestamp date, news news_comments){
        this.commentsId = commentsId;
        this.contents = contents;
        this.writer = writer;
        this.recommended = recommended;
        this.unrecommended = unrecommended;
        this.date = date;

        if (news_comments!=null){
            changeNews(news_comments);
        }
    }

    public void changeNews(news news_comments){
        this.news_comments = news_comments;
        news_comments.getCommentses().add(this);
    }
}
