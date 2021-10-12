package com.s1c.rtp.repository;

import com.s1c.rtp.entity.*;
import com.s1c.rtp.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordRepository extends JpaRepository<KEYWORDS, Integer>{
}
