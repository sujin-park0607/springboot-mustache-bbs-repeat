package com.rererepeatbbs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rererepeatbbs.domain.dto.ArticleAddRequest;
import com.rererepeatbbs.domain.dto.ArticleAddResponse;
import com.rererepeatbbs.domain.dto.ArticleDto;
import com.rererepeatbbs.domain.dto.ArticleResponse;
import com.rererepeatbbs.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("Json형태로 Response가 잘 오는지")
        // 비즈니스 로직(Service를 검증하지 않음) Controller만 검증
    void jsonResponse() throws Exception {
        ArticleResponse articleResponse = ArticleResponse.builder()
                .id(1L)
                .title("gg")
                .content("gg")
                .build();
        given(articleService.getArticleInfo(1L))
                .willReturn(articleResponse);

        Long articleId = 1L;

        // 앞에서 Autowired한 mockMvc
        String url = String.format("/api/v1/articles/%d", articleId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists()) // $는 루트 안에 hospitalName이 있어야함
                .andExpect(jsonPath("$.title").value("gg"))
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").value("gg"))
                .andDo(print()); // http request, response내역을 출력해라.

        verify(articleService).getArticleInfo(articleId); // getHospital()메소드의 호출이 있었는지 확인
    }

    @Test
    @DisplayName("글 등록이 잘 되는지")
    void add() throws Exception {
        ArticleAddRequest dto = new ArticleAddRequest("gg", "gg");

        given(articleService.addArticle(any())).willReturn(new ArticleAddResponse(1L, dto.getTitle(), dto.getContent()));
        //objectMapper
        String url = "/api/v1/articles/add";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new ArticleAddRequest("gg", "gg")))
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("gg"))
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }
}