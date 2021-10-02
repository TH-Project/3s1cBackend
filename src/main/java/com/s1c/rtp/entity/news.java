package com.s1c.rtp.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"newsId", "title", "url", "date"})
public class news {

    @Id
    @Column(name = "news_id")
    private int newsId;

    private String title;
    private String url;
    private Timestamp date;

//    @JsonIgnore
    @OneToMany(mappedBy = "news_age")
    private List<ageanalysis> ageanalyses = new ArrayList<>();

//    @JsonIgnore
    @OneToMany(mappedBy = "news_comments")
    private List<comments> commentses = new ArrayList<>();

//    @JsonIgnore
    @OneToMany(mappedBy = "news_gender")
    private List<genderanalysis> genderanalyses = new ArrayList<>();

    public news(int newsId, String title, String url, Timestamp date){
        this.newsId = newsId;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public news() {

    }
}
