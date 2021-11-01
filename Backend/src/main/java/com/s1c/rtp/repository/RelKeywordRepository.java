package com.s1c.rtp.repository;

import com.s1c.rtp.dto.GenderDto;
import com.s1c.rtp.dto.KeywordDto;
import com.s1c.rtp.dto.RelKeywordDto;
import com.s1c.rtp.entity.relkeywords;
import com.s1c.rtp.entity.relkeywordsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelKeywordRepository extends JpaRepository<relkeywords, relkeywordsId> {

    @Query("Select n.newsId from news n where n.brief_article Like concat('%', :keyword, '%') order by n.date desc")
    List<Integer> findNewsIdByKeyword(@Param("keyword") String keyword);

    @Query("select new com.s1c.rtp.dto.GenderDto(g.genderId, n.newsId, g.male, g.female) from genderanalysis g join g.news_gender n where n.newsId = :newsId")
    GenderDto findGenderDtoByNewsId(@Param("newsId") int newsId);

    @Query("select new com.s1c.rtp.dto.RelKeywordDto(r.relkeywordsId, r.mentions) from relkeywords r where r.relkeywordsId.keyword= :keyword order by r.mentions desc")
    List<RelKeywordDto> retrieveRelKeywordsBykeyword(@Param("keyword") String keyword);

}