package com.s1c.rtp.repository;

import com.s1c.rtp.entity.genderanalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenderRepository extends JpaRepository<genderanalysis, Integer>{
}
