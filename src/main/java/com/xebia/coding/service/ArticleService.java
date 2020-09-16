package com.xebia.coding.service;

import java.util.Optional;

import com.xebia.coding.domain.Article;

/**
 * This Service interface has CRUD methods of Article Entity.
 * 
 * @author Raghava
 *
 */
public interface ArticleService {

	Article saveArticleDetails(Article article);
	
	Iterable<Article> findAllArticles();
	
	Article findArticleWithId(Long articleId);
	
	Article findArticleWithSlugId(String slugId);

	Article updateOneArticleWithId(String slugId, Article updatedArticle);
	
	void deleteOneArticleWithSlugId(String slugId);
		
}


	

