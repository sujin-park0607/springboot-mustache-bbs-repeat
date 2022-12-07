package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.entity.Hospital;
import com.rererepeatbbs.repository.HospitalRepository;
import com.rererepeatbbs.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/hospital")
public class HospitalController {

    public final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping(value="/{id}")
    public String showHospitalInfo(@PathVariable Integer id, Model model) {
        Optional<Hospital> hospital = hospitalService.showHospitalInfo(id);
        if (hospital.isPresent()) {
            model.addAttribute("hospital", hospital.get());
            return "hospital/show";
        }else{
            return "hospital/error";
        }
    }



    @GetMapping("/list2")
    public String hospitalList(Model model,
                               @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Hospital> hospitalList = hospitalService.pageList(pageable);
        model.addAttribute("hospitals", hospitalList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", hospitalList.hasNext());
        model.addAttribute("hasPrev", hospitalList.hasPrevious());
        return "hospital/list";
    }

    /*@GetMapping("/")
    public String index() {
        return "redirect:./list";
    }*/

    @GetMapping("")
    public String index2(@RequestParam(required = false) String keyword, Pageable pageable, Model model) {
        log.info("keyword:{}", keyword);
        Page<Hospital> hospitals = hospitalService.findByRoadNameAddressContaining(keyword, pageable);
        model.addAttribute("hospitals", hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "hospital/list";
    }
}
