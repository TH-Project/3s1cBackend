package com.s1c.rtp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class relkeywordsId implements Serializable {

    @Column(name = "content")
    String content;

    @Column(name = "keyword")
    String keyword;
}
