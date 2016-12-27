package manju.controller.article.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

public class ArticleData {
	private String id;
	
	private String author;
	
	private String title;
	
	private String body;
	
	private List<String> tags = new ArrayList<>();
	
	private List<String> publicationTarget = new ArrayList<>();
	
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getPublicationTarget() {
		return publicationTarget;
	}

	public void setPublicationTarget(List<String> publicationTarget) {
		this.publicationTarget = publicationTarget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
