package com.hannesthielker.jpaembeddedcollectionevents.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionedArticleRepository extends JpaRepository<VersionedArticle, Long> {
}