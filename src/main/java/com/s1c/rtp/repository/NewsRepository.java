package com.s1c.rtp.repository;

import com.s1c.rtp.dto.KeywordDto;
import com.s1c.rtp.dto.NewsDto;
import com.s1c.rtp.dto.NewsDto2;
import com.s1c.rtp.entity.KEYWORDS;
import com.s1c.rtp.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface NewsRepository extends JpaRepository<news, Integer>{

    @Query("Select n.brief_article from news n where n.brief_article Like concat('%', :keyword, '%') order by n.date desc")
    Page<String> findBriefArticleByKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("select n from news n where n.newsId = :newsId")
    news findnewsByNewsId(@Param("newsId") int newsId);

    @Query("Select n.newsId from news n where n.brief_article Like concat('%', :keyword, '%') order by n.date desc")
    List<Integer> findNewsIdByKeyword(@Param("keyword") String keyword);

    @Query("Select n.newsId from news n where n.brief_article Like concat('%', :keyword, '%') order by n.date desc")
    Page<Integer> findNewsIdByKeyword2(@Param("keyword") String keyword, Pageable pageable);

    @Query("Select n.newsId from news n where n.brief_article Like concat('%', :keyword, '%') order by n.date desc")
    List<Integer> findNewsIdByKeyword3(@Param("keyword") String keyword);

    @Query("select n.brief_article from news n where n.newsId = :newsId")
    Page<String> findBriefArticleByNewsId(@Param("newsId") int newsId, Pageable pageable);



}

