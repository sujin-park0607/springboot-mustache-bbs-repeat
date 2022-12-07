package com.rererepeatbbs.repository;

import com.rererepeatbbs.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    /*List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);

    List<Hospital> findByFullAddressOrBusinessTypeName(String fullAddress, String businessTypeName);

    List<Hospital> findByRoadNameAddressContaining(String keyword); // 포함

    List<Hospital> findByHospitalNameStartingWith(String keyword);   // 시작

    List<Hospital> findByHospitalNameEndsWith(String keyword); // 끝

    List<Hospital> findByTotalNumberOfBedsBetween(int num1, int numb2);

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int num1, int numb2);*/

    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable);
}
