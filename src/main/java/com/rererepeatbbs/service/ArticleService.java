package com.rererepeatbbs.service;

import com.rererepeatbbs.domain.dto.ArticleAddRequest;
import com.rererepeatbbs.domain.dto.ArticleAddResponse;
import com.rererepeatbbs.domain.dto.ArticleResponse;
import com.rererepeatbbs.domain.entity.Article;
import com.rererepeatbbs.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    public final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleResponse getArticleInfo(Long id) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if (optArticle.isPresent()) {
            Article article = optArticle.get();
            return Article.of(article);
        }

        return null;
    }

    public ArticleAddResponse addArticle(ArticleAddRequest dto) {
        Article article = dto.toEntity();
        Article savedArticle = articleRepository.save(article);
        return new ArticleAddResponse(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());
    }


}
