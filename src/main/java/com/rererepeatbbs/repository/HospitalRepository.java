package com.rererepeatbbs.repository;

import com.rererepeatbbs.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
