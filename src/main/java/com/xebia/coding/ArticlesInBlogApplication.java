package com.xebia.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xebia.coding.domain.Article;
import com.xebia.coding.service.ArticleService;

@SpringBootApplication
public class ArticlesInBlogApplication  implements CommandLineRunner {
	
	@Autowired
	private ArticleService articleService;

	public static void main(String[] args) {
		SpringApplication.run(ArticlesInBlogApplication.class, args);
	}

	// Below method is for Initial Data creation.
	@Override
	public void run(String... args) throws Exception {

		Article article = new Article();
		
		article.setTitle("How to learn Spring Booot");
		article.setDescription("How to learn Spring Booot");
		article.setSlug("how-to-learn-spring-boot");
		article.setBody("You have to believe");
		article.setNumberOfWords(234L);

		articleService.saveArticleDetails(article);

		Article article1 = new Article();
		
		article1.setTitle("How to learn Spring MVC");
		article1.setDescription("How to learn Spring MVC");
		article1.setSlug("how-to-learn-spring-mvc");
		article1.setBody("You have to believe");
		article1.setNumberOfWords(777L);
		
		articleService.saveArticleDetails(article1);
		
	}

}
