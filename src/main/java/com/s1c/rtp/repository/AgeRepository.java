package com.s1c.rtp.repository;

import com.s1c.rtp.dto.AgeDto;
import com.s1c.rtp.dto.GenderDto;
import com.s1c.rtp.entity.ageanalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;

public interface AgeRepository extends JpaRepository<ageanalysis, Integer>{

    @Query("select new com.s1c.rtp.dto.AgeDto(a.ageId, n.newsId, a.tens, a.twenties, a.thirties, a.fourties, a.fifties, a.sixties) from ageanalysis a join a.news_age n where n.newsId = :newsId")
    AgeDto findAgeDtoByNewsId(@Param("newsId") int newsId);

}
