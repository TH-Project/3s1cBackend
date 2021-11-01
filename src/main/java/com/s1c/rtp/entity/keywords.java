package com.s1c.rtp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"keywordId","keyword","positive","negative","rank","mentions"})
@Table(name = "KEYWORDS")
public class keywords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int keywordId;

    private String keyword;
    private double positive;
    private double negative;
    private int ranks;
    private int mentions;

    public keywords(int keywordId, String keyword, double positive, double negative, int ranks, int mentions){
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.positive = positive;
        this.negative = negative;
        this.ranks = ranks;
        this.mentions = mentions;
    }
}
