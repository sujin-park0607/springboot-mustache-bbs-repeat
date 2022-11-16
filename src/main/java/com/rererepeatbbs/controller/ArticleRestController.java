package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.dto.ArticleAddRequest;
import com.rererepeatbbs.domain.dto.ArticleAddResponse;
import com.rererepeatbbs.domain.dto.ArticleResponse;
import com.rererepeatbbs.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/articles")
@RestController
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

    @PostMapping("/add")
    public ResponseEntity<ArticleAddResponse> addArticle(ArticleAddRequest dto) {
        ArticleAddResponse articleResponse = articleService.addArticle(dto);
        return ResponseEntity.ok().body(articleResponse);
    }
}
