package com.s1c.rtp.repository;

import com.s1c.rtp.entity.WholeDataNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface WholeDataRepository extends JpaRepository<WholeDataNum, Timestamp> {

    @Modifying
    @Query("update WholeDataNum w set w.today = current_timestamp")
    void updateToday();

    @Query("select count(n) from news n")
    Long numOfNewsData();

    @Query("select count(c) from comments c")
    Long numOfCommentsData();

    @Modifying
    @Query("update WholeDataNum w set w.today_comments = :comments")
    void updateNumOfComments(@Param("comments") Long comments);

    @Modifying
    @Query("update WholeDataNum w set w.today_news = :news")
    void updateNumOfNews(@Param("news") Long news);
}
