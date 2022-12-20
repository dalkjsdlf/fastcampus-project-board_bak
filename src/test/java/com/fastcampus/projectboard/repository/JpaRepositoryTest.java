package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.config.JpaConfig;
import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.ArticleComment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("selecting test")
    @Test
    void givenTestData_whenSeleting_thenWorkFine() {
        //given

        //when
        List<Article> articles = articleRepository.findAll();
        //then
        Assertions.assertThat(articles).isNotNull().hasSize(123);
    }

    @DisplayName("comment selecting test")
    @Test
    void givenTestData_whenCommentSeleting_thenWorkFine() {
        //given

        //when
        List<ArticleComment> articlesComments = articleCommentRepository.findAll();
        //then
        Assertions.assertThat(articlesComments).isNotNull().hasSize(1);
    }

    @DisplayName("inserting test")
    @Test
    void givenTestData_whenInserting_thenWorkFine() {
        //given
        long previousCount = articleRepository.count();
        Article article = Article.of("about earth","this is not content", "#earth");

        //when
        Article savedData = articleRepository.save(article);
        //then

        Assertions.assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("updating test")
    @Test
    void givenTestData_whenUpdating_thenWorkFine() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashtag = "#springboot";
        article.setHashtag(updateHashtag);

        //when
        Article updatedData = articleRepository.saveAndFlush(article);

        //then
        Assertions.assertThat(updatedData).hasFieldOrPropertyWithValue("hashtag",updateHashtag);
    }

    @DisplayName("deleting test")
    @Test
    void givenTestData_whenDeleting_thenWorkFine() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();

        long previousCount        = articleRepository.count();
        long previousCommentCount = articleCommentRepository.count();
        int commentsSize          = article.getArticleCommentSet().size();

        //when
        articleRepository.delete(article);

        //then
        Assertions.assertThat(articleRepository.count()).isEqualTo(previousCount - 1);
        Assertions.assertThat(articleCommentRepository.count()).isEqualTo(previousCommentCount - commentsSize);
    }

}