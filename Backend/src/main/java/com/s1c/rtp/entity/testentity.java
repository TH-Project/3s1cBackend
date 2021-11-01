package com.s1c.rtp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // @Entity annotation indicates that the class is a persistent Java class.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "testentity")
public class testentity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "ranking")
    private int ranking;
}