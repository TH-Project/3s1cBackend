package com.s1c.rtp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"ageId", "tens", "twenties", "thirties", "fourties", "fifties", "sixties"})
public class ageanalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "age_id")
    private int ageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    @JsonIgnore
    private news news_age;

    private double tens;
    private double twenties;
    private double thirties;
    private double fourties;
    private double fifties;
    private double sixties;
}
