package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@DisplayName("Data REST 테스트")
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {
    
    private MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("api 게시글 다건 조회")
    @Test
    void given_whenRequestingArticles_thenReturnArticlesJsonResponse() throws Exception {
        //given

        //when

        //then
        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("Application/hal+json")))
                .andDo(print());

    }

    @DisplayName("api 게시글 단건 조회")
    @Test
    void givenNothing_whenRequestingArticle_thenReturnArticleJsonResponse() throws Exception {
        //given

        //when

        //then
        mvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("Application/hal+json")))
                .andDo(print());
    }

    @DisplayName("api 댓글 다건 조회")
    @Test
    void givenNothing_whenRequestingArticleComments_thenReturnArticleCommentsJsonResponse() throws Exception {
        //given

        //when

        //then
        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("Application/hal+json")))
                .andDo(print());
    }

    @DisplayName("api 댓글 단건 조회")
    @Test
    void givenNothing_whenRequestingArticleComment_thenReturnArticleCommentJsonResponse() throws Exception {
        //given

        //when

        //then
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("Application/hal+json")))
                .andDo(print());
    }

    @DisplayName("api 단건 게시글 -> 댓글 조회")
    @Test
    void givenNothing_whenRequestingArticleWithComments_thenReturnArticleWithCommentsJsonResponse() throws Exception {
        //given

        //when

        //then
        mvc.perform(get("/api/articles/1/articleCommentSet/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("Application/hal+json")))
                .andDo(print());
    }

}