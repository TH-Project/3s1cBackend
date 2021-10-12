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
public class KEYWORDS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int keywordId;

    private String keyword;
    private double positive;
    private double negative;
    private int rank;
    private int mentions;

    public KEYWORDS(int keywordId, String keyword, double positive, double negative, int rank, int mentions){
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.positive = positive;
        this.negative = negative;
        this.rank = rank;
        this.mentions = mentions;
    }
}
