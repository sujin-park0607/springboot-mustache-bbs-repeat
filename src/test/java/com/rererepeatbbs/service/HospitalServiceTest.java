package com.rererepeatbbs.service;

import com.rererepeatbbs.domain.dto.HospitalResponse;
import com.rererepeatbbs.domain.entity.Hospital;
import com.rererepeatbbs.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HospitalServiceTest {
    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("3일때 폐업중이 잘 나오는지")
    void close() {
        Hospital hospital1 = Hospital.builder()
                .id(2321)
                .businessStatusCode(3)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital1));

        HospitalResponse hospital = hospitalService.getHospital(2321);
        assertEquals("폐업", hospital.getBusinessStatusName());
    }

    @Test
    @DisplayName("13일때 영업중")
    void open(){
        Hospital hospital1 = Hospital.builder()
                .id(1234)
                .businessStatusCode(13)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital1));

        HospitalResponse hospital = hospitalService.getHospital(1234);
        assertEquals("영업중", hospital.getBusinessStatusName());
    }
}