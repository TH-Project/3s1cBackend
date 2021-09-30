package com.s1c.rtp.entity;

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
    private news news_comments;

    private String contents;
    private String writer;
    private int recommended;
    private int unrecommended;
    private Timestamp date;
}
