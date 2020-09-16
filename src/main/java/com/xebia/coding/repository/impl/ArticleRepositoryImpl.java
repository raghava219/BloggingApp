package com.xebia.coding.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.xebia.coding.domain.Article;
import com.xebia.coding.repository.ArticleRepositoryCustom;

/**
 * This is a Article Custom Repository Implementation  
 * @author Raghava
 *
 */
@Repository
@Transactional
public class ArticleRepositoryImpl implements ArticleRepositoryCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Article getArticleBySlugId(String slug) {
		Query query = entityManager.createNativeQuery("SELECT em.* FROM article as em WHERE em.slug = ?", Article.class);
        query.setParameter(1, slug);
        return (Article) query.getSingleResult();
	}

}
