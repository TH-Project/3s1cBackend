package com.s1c.rtp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"genderId", "male", "female"})
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
}
