package manju.query.article;

import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manju.domain.article.event.ArticleRegisteredEvent;
import manju.domain.article.event.ArticleUpdatedEvent;

@Component
public class ArticleUpdatingEventHandler {
	@Autowired
	private ArticleRepository repository;
	
	@EventHandler
	public void onRegisterd(ArticleRegisteredEvent event){
		Article article = new Article();
		article.setId(event.getId().getValue().toString());
		article.setAuthor(event.getAuthor().getValue());
		article.setTitle(event.getTitle().getValue());
		article.setBody(event.getBody().getValue());
		article.setTags(event.getTags().getValue().stream().map(tag -> tag.getValue()).collect(Collectors.toList()));
		article.setPublicationTarget(event.getPublicationTargets().getValue().stream().map(target -> target.getValue()).collect(Collectors.toList()));
		article.setPublishedDateTime(Date.from( event.getPublishedDateTime().getValue().atZone(ZoneId.systemDefault()).toInstant()));
		article.setStatus(event.getStatus().name());
		article.setRegisteredDateTime(Date.from( event.getRegisteredDateTime().getValue().atZone(ZoneId.systemDefault()).toInstant()));
		article.setModifiedDateTime(Date.from( event.getModifiedDateTime().getValue().atZone(ZoneId.systemDefault()).toInstant()));
		
		repository.save(article);

	}
	
	@EventHandler
	public void onRegisterd(ArticleUpdatedEvent event){
		Article article = repository.findOne(event.getId().toString());
		article.setAuthor(event.getAuthor().getValue());
		article.setTitle(event.getTitle().getValue());
		article.setBody(event.getBody().getValue());
		article.setTags(event.getTags().getValue().stream().map(tag -> tag.getValue()).collect(Collectors.toList()));
		article.setPublicationTarget(event.getPublicationTargets().getValue().stream().map(target -> target.getValue()).collect(Collectors.toList()));
		article.setPublishedDateTime(Date.from( event.getPublishedDateTime().getValue().atZone(ZoneId.systemDefault()).toInstant()));
		article.setStatus(event.getStatus().name());
		article.setModifiedDateTime(Date.from( event.getModifiedDateTime().getValue().atZone(ZoneId.systemDefault()).toInstant()));
		
		
		
		repository.save(article);

	}
}
