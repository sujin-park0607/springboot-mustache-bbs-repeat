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

    @GetMapping("/{id}")
    public String selectById(@PathVariable Long id, Model model){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
            return"article/show";
        }else{
            return "article/error";
        }
    }

    @GetMapping("/list")
    public String articleList(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "article/list";
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/articles/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            log.info("삭제 되지 않았습니다.");
            return "redirect:./";
        }else{
            log.info("{} 삭제되었습니다.", id);
            return "redirect:/articles/list";
        }
    }

    @GetMapping("/{id}/edit")
    public String updateArticlePage(@PathVariable Long id, Model model){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
            return "article/edit";
        }else{
            return "redirect:/articles/list";
        }
    }

    @PostMapping("/{id}/edit")
    public String updateArticle(ArticleDto articleDto, Model model){
        Article article = articleRepository.save(articleDto.toEntity());
        return "redirect:/articles/" + article.getId();
    }

}
