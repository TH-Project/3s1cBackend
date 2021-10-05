package com.s1c.rtp.repository;


import com.s1c.rtp.dto.CommentsDto;
import com.s1c.rtp.dto.GroupByDto;
import com.s1c.rtp.entity.comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<comments, Integer>{

    @Query("select new com.s1c.rtp.dto.CommentsDto(c.commentsId, n.title, c.contents, c.writer) from comments c join c.news_comments n where c.commentsId < 3")
    List<CommentsDto> findCommentsWithNews();

    @Query("select count(distinct c.writer) from comments c")
    Long returnNumOfWriters();

//    @Query("select new com.s1c.rtp.dto.GroupByDto(:numOfComments, :numOfWriters) from comments c")
//    List<GroupByDto> returnWritersNComments(@Param("numOfComments") Long numOfComments, @Param("numOfWriters") Long numOfWriters);
}
