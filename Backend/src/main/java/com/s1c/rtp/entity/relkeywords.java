package com.s1c.rtp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "relkeywords")
public class relkeywords {

    @EmbeddedId
    relkeywordsId relkeywordsId;

    @Column(name ="mentions")
    int mentions;

}