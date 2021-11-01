package com.s1c.rtp.repository;

import com.s1c.rtp.entity.*;
import com.s1c.rtp.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WholeDataRepository extends JpaRepository<WholeDataNum, Integer> {

    @Query("select count(n) from news n")
    Long numOfNewsData();

    @Query("select count(c) from comments c")
    Long numOfCommentsData();

    @Query("select new com.s1c.rtp.dto.WholeDataDto2(w.today_comments, w.today_news, w.today_writers, w.hist_comments, w.hist_news, w.hist_writers) from WholeDataNum w")
    WholeDataDto2 returnWholeDataNum();
}
