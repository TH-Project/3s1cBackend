package com.s1c.rtp.repository;

import com.s1c.rtp.entity.news;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewsRepository extends JpaRepository<news, Integer>{
}
