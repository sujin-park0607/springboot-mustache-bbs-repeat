package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.dto.ArticleDto;
import com.rererepeatbbs.domain.entity.Article;
import com.rererepeatbbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String newArticlePage(){
        return "article/new";
    }

    @PostMapping("/new")
    public String newArticle(@ModelAttribute ArticleDto articleDto){
        Article article = articleRepository.save(articleDto.toEntity());
        return "redirect:/articles/" + article.getId();
    }

}
