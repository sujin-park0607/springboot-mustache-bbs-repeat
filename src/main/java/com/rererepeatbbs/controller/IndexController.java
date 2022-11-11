package com.rererepeatbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @GetMapping("")
    public String index2(){
        return "redirect:./";
    }
}
