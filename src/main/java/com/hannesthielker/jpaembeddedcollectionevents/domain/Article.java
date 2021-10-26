package com.hannesthielker.jpaembeddedcollectionevents.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(EventListener.class)
public class Article {

    @Id
    private Long id;

    private String articleNumber;

    @ElementCollection
    private List<Tag> tags = new ArrayList<>();

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
