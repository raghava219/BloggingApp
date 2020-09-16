package com.xebia.coding.bean;

/**
 * This is JsonResponse POJO for returning JSON response
 * 
 * @author Raghava
 *
 */
public class JsonResponse {

	private String articleId;

	private TimeToRead timeToRead;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public TimeToRead getTimeToRead() {
		return timeToRead;
	}

	public void setTimeToRead(TimeToRead timeToRead) {
		this.timeToRead = timeToRead;
	}

}
