package com.rererepeatbbs.domain.dto;

import com.rererepeatbbs.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleAddRequest {
    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .build();
    }
}
