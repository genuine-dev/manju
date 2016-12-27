package manju.domain.article.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import manju.domain.article.ArticleId;
import manju.domain.article.Author;
import manju.domain.article.Body;
import manju.domain.article.ModifiedDateTime;
import manju.domain.article.PublicationTargets;
import manju.domain.article.PublishedDateTime;
import manju.domain.article.RegisteredDateTime;
import manju.domain.article.Status;
import manju.domain.article.Tags;
import manju.domain.article.Title;

public class UpdateArticleCommand {
	@TargetAggregateIdentifier
	@NotNull
	@Valid
	private final ArticleId id;

	@NotNull
	@Valid
	private final Author author;

	@NotNull
	@Valid
	private final Title title;

	@NotNull
	@Valid
	private final Body body;

	@NotNull
	@Valid
	private final Tags tags;

	@NotNull
	@Valid
	private final PublicationTargets publicationTargets;

	@NotNull
	@Valid
	private final Status status;

	@Valid
	private final PublishedDateTime publishedDateTime;

	@NotNull
	@Valid
	private final ModifiedDateTime modifiedDateTime;

	public UpdateArticleCommand(ArticleId id, Author author, Title title, Body body, Tags tags,
			PublicationTargets publicationTargets, Status status, PublishedDateTime publishedDateTime,
			ModifiedDateTime modifiedDateTime) {
		super();
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
