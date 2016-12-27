package manju.domain.article;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import manju.domain.article.command.RegisterArticleCommand;
import manju.domain.article.command.UpdateArticleCommand;
import manju.domain.article.event.ArticleRegisteredEvent;
import manju.domain.article.event.ArticleUpdatedEvent;

public class Article extends AbstractAnnotatedAggregateRoot<ArticleId>{
	
	@AggregateIdentifier
	private ArticleId id;
	
	private Author author;
	
	private Title title;
	
	private Body body;
	
	private Tags tags;
	
	private PublicationTargets publicationTargets;
	
	private Status status;
	
	private PublishedDateTime publishedDateTime;
	
	private RegisteredDateTime registeredDateTime;
	
	private ModifiedDateTime modifiedDateTime;
	
	@SuppressWarnings("unused")
	private Article() {}

	@CommandHandler
	public Article(RegisterArticleCommand command){
		apply(new ArticleRegisteredEvent(
					command.getId(),
					command.getAuthor(),
					command.getTitle(),
					command.getBody(),
					command.getTags(),
					command.getPublicationTargets(),
					command.getStatus(),
					command.getPublishedDateTime(),
					command.getRegisteredDateTime(),
					command.getModifiedDateTime()
				));
	}
	
	@CommandHandler
	public void update(UpdateArticleCommand command){
		apply(new ArticleUpdatedEvent(
				command.getId(),
				command.getAuthor(),
				command.getTitle(),
				command.getBody(),
				command.getTags(),
				command.getPublicationTargets(),
				command.getStatus(),
				command.getPublishedDateTime(),
				command.getModifiedDateTime()
			));
	}
	
	@EventHandler
	public void on(ArticleRegisteredEvent event){
		this.id = event.getId();
		this.author = event.getAuthor();
		this.title = event.getTitle();
		this.body = event.getBody();
		this.tags = event.getTags();
		this.publicationTargets = event.getPublicationTargets();
		this.status = event.getStatus();
		this.publishedDateTime = event.getPublishedDateTime();
		this.registeredDateTime = event.getRegisteredDateTime();
		this.modifiedDateTime = event.getModifiedDateTime();
	}
	
	@EventHandler
	public void on(ArticleUpdatedEvent event){
		this.author = event.getAuthor();
		this.title = event.getTitle();
		this.body = event.getBody();
		this.tags = event.getTags();
		this.publicationTargets = event.getPublicationTargets();
		this.status = event.getStatus();
		this.publishedDateTime = event.getPublishedDateTime();
		this.modifiedDateTime = event.getModifiedDateTime();
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
	
	public RegisteredDateTime getRegisteredDateTime() {
		return registeredDateTime;
	}
	
	public ModifiedDateTime getModifiedDateTime() {
		return modifiedDateTime;
	}
}
