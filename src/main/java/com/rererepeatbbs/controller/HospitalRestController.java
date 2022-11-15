package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.dto.HospitalResponse;
import com.rererepeatbbs.domain.entity.Hospital;
import com.rererepeatbbs.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        Optional<Hospital> hospital = hospitalService.findById(id);    // Entity
        if (hospital.isPresent()) {
            HospitalResponse hospitalResponse = Hospital.of(hospital.get());
            return ResponseEntity.ok().body(hospitalResponse);
        }
        return null;
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospital(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }

}
