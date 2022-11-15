package com.rererepeatbbs.repository;

import com.rererepeatbbs.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    /*@Autowired
    HospitalRepository hospitalRepository;

    @Test
    void findById() {
        Optional<Hospital> hospital = hospitalRepository.findById(1);
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        assertEquals(1, hp.getId());
    }

    @Test
    @DisplayName("BusinessTypeName이 보건소, 보건지소, 보건진료소인 데이터가 잘 나오는지 확인")
    void findByBusinessTypeNamIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (var hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    @DisplayName("BusinessTypeName이 보건소, 보건지소, 보건진료소인 데이터가 잘 나오는지 확인")
    void findByFullAddressAndBusinessTypeName() {
        String fullAddress = "%수원시%";
        String businessTypeName = "%의원";
        List<Hospital> hospitals = hospitalRepository.findByFullAddressOrBusinessTypeName(fullAddress, businessTypeName);

        for (var hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    void findByRoadNameAddressContaining() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void findByHospitalNameStartingWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartingWith("경희");
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void findByHospitalNameEndsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("의원");
        printHospitalNameAndAddress(hospitals);
    }


    void printHospitalNameAndAddress(List<Hospital> hospitals) {
        for (var hospital : hospitals) {
            System.out.printf("%s | %s |%d %f\n", hospital.getHospitalName(), hospital.getRoadNameAddress(), hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize());
        }

        System.out.println(hospitals.size());
    }


    @Test
    void findByTotalNumberOfBedsBetween() {
        List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsBetween(10, 19);
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void findByPatientRoomCountBetweenOrderByPatientRoomCountDesc() {
        List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsBetween(10, 19);
        printHospitalNameAndAddress(hospitals);
    }*/
}
