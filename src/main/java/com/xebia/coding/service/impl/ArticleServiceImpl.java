package com.xebia.coding.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.xebia.coding.domain.Article;
import com.xebia.coding.repository.ArticleRepository;
import com.xebia.coding.repository.ArticleRepositoryCustom;
import com.xebia.coding.service.ArticleService;
import com.xebia.coding.service.custom.exception.ArticleNotFoundException;


/**
 * This is Service Implementation class for Article Entity
 * 
 * @author Raghava
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ArticleRepositoryCustom articleRepositoryCustom;
	
	@Override
	public Article saveArticleDetails(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Iterable<Article> findAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article findArticleWithId(Long articleId) {
		return articleRepository.findById(articleId).orElseThrow(() -> new ArticleNotFoundException(articleId));
	}

	@Override
	public Article findArticleWithSlugId(String slugId) {
		return articleRepositoryCustom.getArticleBySlugId(slugId);
	}

	@Override
	public Article updateOneArticleWithId(String slugId, Article updatedArticle) {
		
		Article article = articleRepositoryCustom.getArticleBySlugId(slugId);
		
		return articleRepository.findById(article.getId())
				.map(art -> {
					art.setTitle(updatedArticle.getTitle());
					art.setBody(updatedArticle.getBody());
					art.setDescription(updatedArticle.getDescription());
					return articleRepository.save(art);
				})
				.orElseThrow(() -> new ArticleNotFoundException(article.getId()));
	}

	@Override
	public void deleteOneArticleWithSlugId(String slugId) {
		Article article = articleRepository.getArticleBySlugId(slugId);
		articleRepository.deleteById(article.getId());
	}
	
	
}
