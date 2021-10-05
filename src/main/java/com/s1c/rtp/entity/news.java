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
@ToString(of= {"newsId", "title", "url", "date", "brief_article"})
public class news {

    @Id
    @Column(name = "news_id")
    private int newsId;

    private String title;
    private String url;
    private Timestamp date;
    private String brief_article;

//    @JsonIgnore
    @OneToMany(mappedBy = "news_age")
    private List<ageanalysis> ageanalyses = new ArrayList<>();

//    @JsonIgnore
    @OneToMany(mappedBy = "news_comments")
    private List<comments> commentses = new ArrayList<>();

//    @JsonIgnore
    @OneToMany(mappedBy = "news_gender")
    private List<genderanalysis> genderanalyses = new ArrayList<>();

    public news(int newsId, String title, String url, Timestamp date, String brief_article){
        this.newsId = newsId;
        this.title = title;
        this.url = url;
        this.date = date;
        this.brief_article = brief_article;
    }

}
