package com.s1c.rtp.repository;

import com.s1c.rtp.dto.NewsDto;
import com.s1c.rtp.entity.KEYWORDS;
import com.s1c.rtp.entity.news;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<news, Integer>{

    @Query("Select n.brief_article from news n where n.brief_article Like concat('%', :keyword, '%') order by n.date desc")
    public Page<String> findBriefArticleByKeyword(@Param("keyword") String keyword, Pageable pageable);


}

