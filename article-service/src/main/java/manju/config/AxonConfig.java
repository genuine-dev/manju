package manju.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandHandlerInterceptor;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerBeanPostProcessor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.commandhandling.interceptors.BeanValidationInterceptor;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerBeanPostProcessor;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import manju.domain.article.Article;

@Configuration
public class AxonConfig {

	@Bean
	public CommandBus commandBus(){
		SimpleCommandBus commandBus = new SimpleCommandBus();
		List<CommandHandlerInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new BeanValidationInterceptor());
		commandBus.setHandlerInterceptors(interceptors);
		
		return commandBus;
	}
	
	@Bean
	public CommandGateway commandGateway() {
		return new DefaultCommandGateway(commandBus());
	}

	@Bean
	public EventBus eventBus() {
		return new SimpleEventBus();
	}

	@Bean
	public EventStore eventStore() {
		return new FileSystemEventStore(new SimpleEventFileResolver(new File("./events")));
	}

	@Bean
	public EventSourcingRepository<Article> articleEventSourcingRepository() {
		EventSourcingRepository<Article> repository = new EventSourcingRepository<>(Article.class, eventStore());
		repository.setEventBus(eventBus());

		return repository;
	}

	@Bean
	public AggregateAnnotationCommandHandler<Article> articleCommandHandler() {
		@SuppressWarnings("unchecked")
		AggregateAnnotationCommandHandler<Article> commandHandler = AggregateAnnotationCommandHandler.subscribe(Article.class,
				articleEventSourcingRepository(), commandBus());
		
		return commandHandler;
	}

	@Bean
	public AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor() {
		AnnotationCommandHandlerBeanPostProcessor processor = new AnnotationCommandHandlerBeanPostProcessor();
		processor.setCommandBus(commandBus());

		return processor;
	};

	@Bean
	public AnnotationEventListenerBeanPostProcessor annotationEventListenerBeanPostProcessor() {
		AnnotationEventListenerBeanPostProcessor processor = new AnnotationEventListenerBeanPostProcessor();
		processor.setEventBus(eventBus());

		return processor;
	}

}
