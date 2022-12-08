package com.rererepeatbbs.service;

import com.rererepeatbbs.domain.dto.VisitCreateRequest;
import com.rererepeatbbs.domain.dto.VisitResponse;
import com.rererepeatbbs.domain.entity.Hospital;
import com.rererepeatbbs.domain.entity.User;
import com.rererepeatbbs.domain.entity.Visit;
import com.rererepeatbbs.exception.ErrorCode;
import com.rererepeatbbs.exception.HospitalReviewAppException;
import com.rererepeatbbs.repository.HospitalRepository;
import com.rererepeatbbs.repository.UserRepository;
import com.rererepeatbbs.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;

    public void createVisit(VisitCreateRequest dto, String userName) {

        // hospital이 없을 때 등록불가
        Hospital hospital = hospitalRepository.findById(dto.getHospitalId())
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUNDED, String.format("hospitalId:%s 가 없습니다.", dto.getHospitalId())));

        // user가 없을 때 등록불가
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.USER_NOT_FOUNDED, String.format("%s user가 없습니다.", userName)));

        Visit visit = Visit.builder()
                .user(user)
                .hospital(hospital)
                .disease(dto.getDisease())
                .amount(dto.getAmount())
                .build();
        visitRepository.save(visit);
    }

    public List<VisitResponse> findAllByPage(Pageable pageable) {
        Page<Visit> visits = visitRepository.findAll(pageable);

        return visits.stream()
                .map(Visit::toResponse)
                .collect(Collectors.toList());

    }
}