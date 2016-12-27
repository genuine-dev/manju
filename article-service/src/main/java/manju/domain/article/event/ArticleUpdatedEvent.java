package manju.domain.article.event;

import manju.domain.article.ArticleId;
import manju.domain.article.Author;
import manju.domain.article.Body;
import manju.domain.article.ModifiedDateTime;
import manju.domain.article.PublicationTargets;
import manju.domain.article.PublishedDateTime;
import manju.domain.article.Status;
import manju.domain.article.Tags;
import manju.domain.article.Title;

public class ArticleUpdatedEvent {
	private ArticleId id;

	private final Author author;

	private final Title title;

	private final Body body;

	private final Tags tags;

	private final PublicationTargets publicationTargets;

	private final Status status;

	private final PublishedDateTime publishedDateTime;

	private final ModifiedDateTime modifiedDateTime;

	public ArticleUpdatedEvent(ArticleId id, Author author, Title title, Body body, Tags tags,
			PublicationTargets publicationTargets, Status status, PublishedDateTime publishedDateTime,
			ModifiedDateTime modifiedDateTime) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.body = body;
		this.tags = tags;
		this.publicationTargets = publicationTargets;
		this.status = status;
		this.publishedDateTime = publishedDateTime;
		this.modifiedDateTime = modifiedDateTime;

	}

	public ArticleId getId() {
		return id;
	}

	public Author getAuthor() {
		return author;
	}

	public Title getTitle() {
		return title;
	}

	public Body getBody() {
		return body;
	}

	public Tags getTags() {
		return tags;
	}

	public PublicationTargets getPublicationTargets() {
		return publicationTargets;
	}

	public Status getStatus() {
		return status;
	}

	public PublishedDateTime getPublishedDateTime() {
		return publishedDateTime;
	}

	public ModifiedDateTime getModifiedDateTime() {
		return modifiedDateTime;
	}
}
