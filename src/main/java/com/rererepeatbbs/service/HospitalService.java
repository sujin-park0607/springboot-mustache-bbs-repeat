package com.rererepeatbbs.service;

import com.rererepeatbbs.domain.entity.Hospital;
import com.rererepeatbbs.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HospitalService {
    public final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional(readOnly = true)
    public Page<Hospital> pageList(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }

    public Optional<Hospital> showHospitalInfo(Integer id) {
        return hospitalRepository.findById(id);
    }
}
