package com.xebia.coding.cotroller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xebia.coding.controller.ArticleController;
import com.xebia.coding.domain.Article;
import com.xebia.coding.service.ArticleService;

/**
 * This is the Test class for ArticleController
 * 
 * @author Raghava
 *
 */
public class ArticleControllerTest {

	private ArticleService articleServiceMock = EasyMock.createMock(ArticleService.class);

	public ArticleControllerTest() {

	}

	ArticleController articleController = new ArticleController();

	@Before
	public void before() {
		articleController.setArticleService(articleServiceMock);
	}

	@After
	public void after() {
	}

	@Test
	public void testGetAllArticleDetails() {
		List<Article> expectedListOfArticles = this.getTestDataForAllArticles();
		List<Article> actualListOfArticles = null;

		EasyMock.expect(articleServiceMock.findAllArticles()).andReturn(expectedListOfArticles);
		EasyMock.replay(articleServiceMock);

		try {
			actualListOfArticles = (List<Article>) articleController.getAllArticleDetails();
		} catch (Exception e) {
			assertFalse("Articles in Blog Exception" + e.getMessage(), true);
		}

		assertEquals(expectedListOfArticles.size(), actualListOfArticles.size());

	}

	@Test
	public void testAddArticleDetails() {
		ResponseEntity<Object> responseEntity = null;

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Article singleArticle = this.getTestDataForAllArticles().get(0);

		EasyMock.expect(articleServiceMock.saveArticleDetails(EasyMock.anyObject())).andReturn(singleArticle);
		EasyMock.replay(articleServiceMock);

		try {
			responseEntity = articleController.addArticleDetails(singleArticle, singleArticle.getSlug());
		} catch (Exception e) {
			assertFalse("Articles in Blog Exception " + e.getMessage(), true);
		}

		assertNotNull(responseEntity.getBody());
	}

	@Test
	public void testUpdateArticleDetails() {
		ResponseEntity<Object> responseEntity = null;

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Article updateArticle = this.getTestDataForAllArticles().get(0);
		Article newArticle = this.getTestDataForAllArticles().get(1);
		
		updateArticle.setTitle(newArticle.getTitle());
		updateArticle.setDescription(newArticle.getDescription());
		updateArticle.setBody(newArticle.getBody());

		
		EasyMock.expect(articleServiceMock.findArticleWithSlugId(updateArticle.getSlug())).andReturn(updateArticle);
		EasyMock.expect(articleServiceMock.saveArticleDetails(EasyMock.anyObject())).andReturn(updateArticle);
		EasyMock.replay(articleServiceMock);

		try {
			responseEntity = articleController.updateArticleDetails(updateArticle, updateArticle.getSlug());
		} catch (Exception e) {
			assertFalse("Articles in Blog Exception " + e.getMessage(), true);
		}

		assertNotNull(responseEntity.getBody());

	}

	@Test
	public void testGetSpecificArticleDetailsBySlugId() {

		Article expectedArticle = this.getTestDataForAllArticles().get(0);
		Article actualArticle = null;
		
		EasyMock.expect(articleServiceMock.findArticleWithSlugId(expectedArticle.getSlug())).andReturn(expectedArticle);
		EasyMock.replay(articleServiceMock);
		
		try {
			actualArticle = articleController
										.getSpecificArticleDetailsBySlugId(expectedArticle.getSlug());
		} catch (Exception e) {
			assertFalse("Articles in Blog Exception "+e.getMessage(), true);
		}
		
		assertEquals(expectedArticle, actualArticle);
		
	}

	public List<Article> getTestDataForAllArticles() {

		List<Article> listOfArticles = new ArrayList<>();

		Article article = new Article();
		LocalDateTime createdAt = LocalDateTime.now();
		LocalDateTime updatedAt = LocalDateTime.now();

		article.setId(1);
		article.setTitle("How to learn Spring Booot");
		article.setDescription("How to learn Spring Booot");
		article.setSlug("how-to-learn-spring-boot");
		article.setBody("You have to believe");
		article.setNumberOfWords(234L);
		article.setCreatedAt(createdAt);
		article.setUpdatedAt(updatedAt);
		listOfArticles.add(article);

		Article article1 = new Article();
		article.setId(2);
		article1.setTitle("How to learn Spring MVC");
		article1.setDescription("How to learn Spring MVC");
		article1.setSlug("how-to-learn-spring-mvc");
		article1.setBody("You have to believe");
		article1.setNumberOfWords(777L);
		article1.setCreatedAt(createdAt);
		article1.setUpdatedAt(updatedAt);
		listOfArticles.add(article1);

		return listOfArticles;
	}

}
