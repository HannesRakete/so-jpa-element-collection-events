package com.hannesthielker.jpaembeddedcollectionevents.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ArticleTest {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    VersionedArticleRepository versionedArticleRepository;

    @SpyBean
    EventConsumer consumer;

    @Test
    void articleTest() {
        // given
        Article article = new Article();
        article.setId(1L);
        article.setArticleNumber("testArticleNumber");

        // when
        article = articleRepository.save(article);

        article.setArticleNumber(article.getArticleNumber() + "_2");
        article = articleRepository.save(article);

        Tag tag = new Tag();
        tag.setName("testTag");
        article.setTags(List.of(tag));
        article = articleRepository.save(article);
        articleRepository.delete(article);

        // then
        verify(consumer).prePersist(any());
        verify(consumer).postPersist(any());
        verify(consumer, atLeastOnce()).postLoad(any());
        verify(consumer).preRemove(any());
        verify(consumer).postRemove(any());

        // these will fail
        verify(consumer, times(2)).preUpdate(any());
        verify(consumer, times(2)).postUpdate(any());
    }

    @Test
    void versionedArticleTest() {
        // given
        VersionedArticle article = new VersionedArticle();
        article.setId(1L);
        article.setArticleNumber("testArticleNumber");

        // when
        article = versionedArticleRepository.save(article);

        article.setArticleNumber(article.getArticleNumber() + "_2");
        article = versionedArticleRepository.save(article);

        Tag tag = new Tag();
        tag.setName("testTag");
        article.setTags(List.of(tag));
        article = versionedArticleRepository.save(article);
        versionedArticleRepository.delete(article);

        // then
        verify(consumer).prePersist(any());
        verify(consumer).postPersist(any());
        verify(consumer, atLeastOnce()).postLoad(any());
        verify(consumer).preRemove(any());
        verify(consumer).postRemove(any());

        // these will succeed
        verify(consumer, times(2)).preUpdate(any());
        verify(consumer, times(2)).postUpdate(any());
    }
}