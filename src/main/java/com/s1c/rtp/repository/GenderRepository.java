package com.s1c.rtp.repository;

import com.s1c.rtp.dto.GenderDto;
import com.s1c.rtp.entity.genderanalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenderRepository extends JpaRepository<genderanalysis, Integer>{

    @Query("select new com.s1c.rtp.dto.GenderDto(g.genderId, n.newsId, g.male, g.female) from genderanalysis g join g.news_gender n")
    List<GenderDto> findGenderDto();

    @Query("select new com.s1c.rtp.dto.GenderDto(g.genderId, n.newsId, g.male, g.female) from genderanalysis g join g.news_gender n where n.newsId = :newsId")
    GenderDto findGenderDtoByNewsId(@Param("newsId") int newsId);

}
