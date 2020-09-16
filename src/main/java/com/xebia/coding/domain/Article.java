package com.xebia.coding.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sun.istack.NotNull;

/**
 * Entity class for storing of Article data
 * 
 * @author Raghava
 *
 */

@Entity
@Table(name = "article")
@JsonRootName(value = "article")
public class Article {
	
	public Article() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name="title")
	@NotNull
	private String title;
	
	@Column(name="description")
	@NotNull
	private String description; 

	@Column(name="body")
	@NotNull
	private String body;

	@Column(name="slug")
	private String slug;
	
	@CreationTimestamp
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
	
	@Column(name="numberOfWords", nullable=false)
	private Long numberOfWords;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(Long numberOfWords) {
		this.numberOfWords = numberOfWords;
	}
	
}
