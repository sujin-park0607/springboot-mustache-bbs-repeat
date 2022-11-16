package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.dto.ArticleResponse;
import com.rererepeatbbs.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/articles")
@Controller
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable Long id) {
        ArticleResponse articleResponse = articleService.getArticleInfo(id);
        return ResponseEntity.ok().body(articleResponse);
    }

}
