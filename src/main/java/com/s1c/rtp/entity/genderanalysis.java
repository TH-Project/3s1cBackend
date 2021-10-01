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
    private news news_gender;

    private double male;
    private double female;
}
