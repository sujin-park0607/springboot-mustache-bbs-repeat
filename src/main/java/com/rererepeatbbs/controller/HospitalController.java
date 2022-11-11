package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.entity.Hospital;
import com.rererepeatbbs.repository.HospitalRepository;
import com.rererepeatbbs.service.HospitalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    public final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/list")
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

    @GetMapping("/")
    public String index() {
        return "redirect:./list";
    }

    @GetMapping("")
    public String index2() {
        return "redirect:./list";
    }
}
