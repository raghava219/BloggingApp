package com.xebia.coding.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xebia.coding.bean.JsonResponse;
import com.xebia.coding.bean.TimeToRead;
import com.xebia.coding.domain.Article;
import com.xebia.coding.service.ArticleService;

/**
 * This is the main Controller class for Article entity
 * 
 * @author Raghava
 *
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}


	@Autowired
	private Environment env;

	/**
	 * This method will add new article along with SlugId passed as part of URL
	 * @param articleDetails
	 * @param slug
	 * @return Json string of the article added
	 */
	@PostMapping("/articles/{slug}")
	public ResponseEntity<Object> addArticleDetails(@RequestBody Article articleDetails, @PathVariable String slug) {

		articleDetails.setSlug(slug);

		Article savedArticle = articleService.saveArticleDetails(articleDetails);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(savedArticle.getId()).toUri();

		return ResponseEntity.created(location).body(savedArticle);

	}

	/**
	 * This method is for Updating specific Article Details.
	 * 
	 * @param updateArticle
	 * @param slug
	 * @return updated Json string of the article updated
	 */
	@PutMapping("/articles/{slug}")
	public ResponseEntity<Object> updateArticleDetails(@RequestBody Article updateArticle, @PathVariable String slug) {

		Article updatedArticle = articleService.updateOneArticleWithId(slug, updateArticle);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(updatedArticle.getId()).toUri();

		return ResponseEntity.created(location).body(updatedArticle);

	}

	/**
	 * This method is getting the specific Article for passed in slug Id 
	 * 
	 * @param slug
	 * @return article
	 */
	@GetMapping("/articles/{slug}")
	public Article getSpecificArticleDetailsBySlugId(@PathVariable String slug) {

		Article article = articleService.findArticleWithSlugId(slug);
		
		return article;
	}
	
	/**
	 * This method is for deleting the specific Article 
	 * 
	 * @param slug
	 * @return 
	 */
	@DeleteMapping("/articles/{slug}")
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Article Deleted")
	public void deleteSpecificArticleDetailsBySlugId(@PathVariable String slug) {

		articleService.deleteOneArticleWithSlugId(slug);
		
	}

	
	/**
	 * This method will get all the Articles in the system.
	 * 
	 * @return all article
	 */
	@GetMapping("/articles")
	public Iterable<Article> getAllArticleDetails() {
		return articleService.findAllArticles();
	}
	
	
	/**
	 * This method will return JSON response for the Time taken to read specific slug.
	 * @param slug
	 * @return Json string
	 */
	@RequestMapping(path = "/articles/find-time-to-read/{slug}")
	public @ResponseBody JsonResponse getTimetoRead(@PathVariable String slug) {

		Article article = articleService.findArticleWithSlugId(slug);

		long numberOfWords = article.getNumberOfWords();

		JsonResponse jsonResp = new JsonResponse();

		jsonResp.setArticleId(slug);

		TimeToRead timeToRead = new TimeToRead();

		float avgHumanSpeed = Integer.valueOf(env.getProperty("average.human.speed"));

		float timeTaken = (numberOfWords / avgHumanSpeed);

		int minutes = (int) timeTaken;

		timeToRead.setMins(minutes);

		timeToRead.setSeconds(Math.round((timeTaken - minutes) * 100));

		jsonResp.setTimeToRead(timeToRead);

		return jsonResp;

	}

}
