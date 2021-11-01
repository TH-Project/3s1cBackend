package com.s1c.rtp.repository;

import com.s1c.rtp.entity.testentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<testentity, Long> {
}
