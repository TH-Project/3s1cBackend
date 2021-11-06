package com.s1c.rtp.repository;

import com.s1c.rtp.entity.*;
import com.s1c.rtp.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordRepository extends JpaRepository<keywords, Integer>{

    @Query("select new com.s1c.rtp.dto.KeywordDto(k.keywordId, k.keyword, k.positive, k.negative, k.ranks, k.mentions) from keywords k")
    List<KeywordDto> findAllKeyword();

    @Query("Select distinct k.keyword from keywords k where k.keyword = :keyword")
    String findKeywordByKeyword(@Param("keyword") String keyword);

    @Query("select new com.s1c.rtp.dto.KeywordDto(k.keywordId, k.keyword, k.positive, k.negative, k.ranks, k.mentions) from keywords k order by k.ranks")
    Page<KeywordDto> findTopKeyword(Pageable pageable);

    @Query("Select new com.s1c.rtp.dto.KeywordDto (k.keywordId, k.keyword, k.positive, k.negative, k.ranks, k.mentions) from keywords k where k.keyword = :keyword")
    KeywordDto findKeywordDTOByKeyword(@Param("keyword") String keyword);

    @Query("select new com.s1c.rtp.dto.NewsDto3(n.likes, n.sads, n.angries, n.warms) from news n where n.newsId = :news_id")
    NewsDto3 findKeywordNews(@Param("news_id") int news_id);

    @Query("Select new  com.s1c.rtp.dto.SentimentDto (k.negative, k.positive) from keywords k where k.keyword = :keyword")
    SentimentDto findSentimentByKeyword(@Param("keyword") String keyword);

}
