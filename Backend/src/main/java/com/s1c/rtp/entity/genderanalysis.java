package com.s1c.rtp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"genderId", "male", "female"})
public class genderanalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gender_id")
    private int genderId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    @JsonIgnore
    private news news_gender;

    private double male;
    private double female;

    public genderanalysis(int genderId, double male, double female, news news_gender){
        this.genderId = genderId;
        this.male = male;
        this.female = female;
        if (news_gender!=null){
            changeNews(news_gender);
        }
    }

    public void changeNews(news news_gender){
        this.news_gender = news_gender;
        news_gender.getGenderanalyses().add(this);
    }
}
