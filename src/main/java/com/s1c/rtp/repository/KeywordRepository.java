package com.s1c.rtp.repository;

import com.s1c.rtp.entity.*;
import com.s1c.rtp.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordRepository extends JpaRepository<KEYWORDS, Integer>{

    @Query("select new com.s1c.rtp.dto.KeywordDto(k.keywordId, k.keyword, k.positive, k.negative, k.ranks, k.mentions) from KEYWORDS k")
    List<KeywordDto> findAllKeyword();

    @Query("Select k.keyword from KEYWORDS k where k.keyword = :keyword")
    public String findKeywordByKeyword(@Param("keyword") String keyword);


}
