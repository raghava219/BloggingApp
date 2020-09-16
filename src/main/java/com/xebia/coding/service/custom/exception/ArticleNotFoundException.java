package com.xebia.coding.service.custom.exception;

public class ArticleNotFoundException extends RuntimeException {
	
	public ArticleNotFoundException(Long articleId) {
		super("Could not find Article with Id "+articleId);
	}
	
}
