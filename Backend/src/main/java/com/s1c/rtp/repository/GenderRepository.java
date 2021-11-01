package com.s1c.rtp.repository;

import com.s1c.rtp.dto.*;
import com.s1c.rtp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenderRepository extends JpaRepository<genderanalysis, Integer>{

    @Query("select new com.s1c.rtp.dto.GenderDto(g.genderId, n.newsId, g.male, g.female) from genderanalysis g join g.news_gender n")
    List<GenderDto> findGenderDto();

    @Query("select new com.s1c.rtp.dto.GenderDto(g.genderId, n.newsId, g.male, g.female) from genderanalysis g join g.news_gender n where n.newsId = :newsId")
    GenderDto findGenderDtoByNewsId(@Param("newsId") int newsId);

    @Query("select new com.s1c.rtp.dto.GenderDto2(g.male, g.female) from genderanalysis g join g.news_gender n where n.newsId= :newsId")
    GenderDto2 findGenderStatistics(@Param("newsId") int newsId);

}
