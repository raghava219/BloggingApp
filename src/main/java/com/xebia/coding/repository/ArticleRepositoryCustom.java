package com.xebia.coding.repository;

import com.xebia.coding.domain.Article;

/**
 * CRUD Repository for Article Entity 
 * 
 * @author Raghava
 *
 */
public interface ArticleRepositoryCustom {
	
	public Article getArticleBySlugId(String slug);
	

}
