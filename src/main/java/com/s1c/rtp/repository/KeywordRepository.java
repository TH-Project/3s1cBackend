package com.s1c.rtp.repository;

import com.s1c.rtp.entity.*;
import com.s1c.rtp.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordRepository extends JpaRepository<KEYWORDS, Integer>{

    @Query("select new com.s1c.rtp.dto.KeywordDto(k.keywordId, k.keyword, k.positive, k.negative, k.ranks, k.mentions) from KEYWORDS k")
    List<KeywordDto> findAllKeyword();

    @Query("Select distinct k.keyword from KEYWORDS k where k.keyword = :keyword")
    String findKeywordByKeyword(@Param("keyword") String keyword);

    @Query("select new com.s1c.rtp.dto.KeywordDto(k.keywordId, k.keyword, k.positive, k.negative, k.ranks, k.mentions) from KEYWORDS k order by k.ranks")
    Page<KeywordDto> findTopKeyword(Pageable pageable);

    @Query("Select new com.s1c.rtp.dto.KeywordDto (k.keywordId, k.keyword, k.positive, k.negative, k.ranks, k.mentions) from KEYWORDS k where k.keyword = :keyword")
    KeywordDto findKeywordDTOByKeyword(@Param("keyword") String keyword);



}
