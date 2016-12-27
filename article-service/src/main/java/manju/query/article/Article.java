package manju.query.article;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="article")
public class Article {
	@Id
	private String id;
	
	private String author;
	
	private String title;
	
	private String body;
	
	private List<String> tags;
	
	private List<String> publicationTarget;
	
	private Date publishedDateTime;
	
	private String status;

	private Date registeredDateTime;

	private Date modifiedDateTime;

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

	public Date getPublishedDateTime() {
		return publishedDateTime;
	}

	public void setPublishedDateTime(Date publishedDateTime) {
		this.publishedDateTime = publishedDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegisteredDateTime() {
		return registeredDateTime;
	}

	public void setRegisteredDateTime(Date registeredDateTime) {
		this.registeredDateTime = registeredDateTime;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
}
