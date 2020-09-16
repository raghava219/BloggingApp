package com.xebia.coding.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xebia.coding.domain.Article;

/**
 * CRUD Repository for Article Entity 
 * 
 * @author Raghava
 *
 */
@Repository
@Primary
public interface ArticleRepository extends CrudRepository<Article, Long>, ArticleRepositoryCustom {
	
}
