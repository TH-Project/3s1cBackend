package com.s1c.rtp.repository;

import com.s1c.rtp.entity.WholeDataNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface WholeDataRepository extends JpaRepository<WholeDataNum, Timestamp> {

}
