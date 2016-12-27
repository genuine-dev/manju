package manju.controller.article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import manju.controller.article.dto.ArticleData;
import manju.controller.article.dto.User;
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
import manju.domain.article.command.RegisterArticleCommand;
import manju.domain.article.command.UpdateArticleCommand;
import manju.query.article.Article;
import manju.query.article.ArticleRepository;

@RestController
public class ArticleController {
	@Autowired
	private OAuth2RestTemplate restTemplate;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private ArticleRepository repository;
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String registerArticle(@RequestBody ArticleData data){
		UUID uuid = UUID.randomUUID();
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		RegisterArticleCommand command = new RegisterArticleCommand(
				new ArticleId(uuid),
				new Author(me.getId()),
				new Title(data.getTitle()), 
				new Body(data.getBody()), 
				new Tags(data.getTags()),
				new PublicationTargets(data.getPublicationTarget()),
				Status.valueOf(data.getStatus()), 
				(data.getStatus().equals("PUBLISHED"))? new PublishedDateTime(LocalDateTime.now()): null,
				new RegisteredDateTime(LocalDateTime.now()),
				new ModifiedDateTime(LocalDateTime.now())
		);
				
		commandGateway.send(command);
		
		return "{\"id\": " + uuid.toString() + "}";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String updateArticle(@PathVariable("id") String id, @RequestBody ArticleData data){
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		@SuppressWarnings("unchecked")
		List<String> target = restTemplate.getForObject("http://user-service/me/groups", List.class);
		Article article = repository.findById(id, target, me.getId());
		if(article == null || !me.getId().equals(article.getAuthor())){
			throw new RuntimeException();
		}
		
		UpdateArticleCommand command = new UpdateArticleCommand(
				new ArticleId(UUID.fromString(id)),
				new Author(data.getAuthor()),
				new Title(data.getTitle()), 
				new Body(data.getBody()), 
				new Tags(data.getTags()),
				new PublicationTargets(data.getPublicationTarget()),
				Status.valueOf(data.getStatus()), 
				(data.getStatus() == "PUBLISHED")? new PublishedDateTime(LocalDateTime.now()): null,
				new ModifiedDateTime(LocalDateTime.now())
		);
				
		commandGateway.send(command);
		
		return "{\"id\": \"" + id + "\"}";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Article findById(@PathVariable("id") String id){
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		@SuppressWarnings("unchecked")
		List<String> target = restTemplate.getForObject("http://user-service/me/groups", List.class);
		return repository.findById(id, target, me.getId());
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Page<Article> findAll(@RequestParam("page") int page){
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		@SuppressWarnings("unchecked")
		List<String> target = restTemplate.getForObject("http://user-service/me/groups", List.class);
		return repository.findAll(target, me.getId(), new PageRequest(page, 20, Direction.DESC, "registeredDateTime"));
	}
	
	@RequestMapping(value="/keyword", method=RequestMethod.GET)
	public Page<Article>  findByKeyword(@RequestParam("keyword") String keyword, @RequestParam("page") int page, PagedResourcesAssembler<Article> assembler){
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		@SuppressWarnings("unchecked")
		List<String> target = restTemplate.getForObject("http://user-service/me/groups", List.class);
		return  repository.findByKeyword(keyword, target, me.getId(), new PageRequest(page, 20, Direction.DESC, "registeredDateTime"));
	}

	@RequestMapping(value="/tag/{tag}", method=RequestMethod.GET)
	public Page<Article> findByTag(@PathVariable("tag") String tag, @RequestParam("page") int page){
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		@SuppressWarnings("unchecked")
		List<String> target = restTemplate.getForObject("http://user-service/me/groups", List.class);
		return repository.findByTag(tag, target, me.getId(), new PageRequest(page, 20, Direction.DESC, "registeredDateTime"));
	}
	
	@RequestMapping(value="mine", method=RequestMethod.GET)
	public Page<Article> findMine(@RequestParam("page") int page){
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		@SuppressWarnings("unchecked")
		List<String> target = restTemplate.getForObject("http://user-service/me/groups", List.class);
		return repository.findMine(me.getId(), new PageRequest(page, 20, Direction.DESC, "registeredDateTime"));
	}
}
