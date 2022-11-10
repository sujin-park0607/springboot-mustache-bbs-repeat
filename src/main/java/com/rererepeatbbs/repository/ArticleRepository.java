package com.rererepeatbbs.repository;

import com.rererepeatbbs.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
