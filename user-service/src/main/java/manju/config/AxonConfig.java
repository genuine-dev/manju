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

import manju.domain.orgamization.Organization;
import manju.domain.user.User;

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
	public EventSourcingRepository<User> userEventSourcingRepository() {
		EventSourcingRepository<User> repository = new EventSourcingRepository<>(User.class, eventStore());
		repository.setEventBus(eventBus());

		return repository;
	}

	@Bean
	public EventSourcingRepository<Organization> organizationEventSourcingRepository() {
		EventSourcingRepository<Organization> repository = new EventSourcingRepository<>(Organization.class, eventStore());
		repository.setEventBus(eventBus());

		return repository;
	}

	@Bean
	public AggregateAnnotationCommandHandler<User> userCommandHandler() {
		@SuppressWarnings("unchecked")
		AggregateAnnotationCommandHandler<User> commandHandler = AggregateAnnotationCommandHandler.subscribe(User.class,
				userEventSourcingRepository(), commandBus());
		
		return commandHandler;
	}

	@Bean
	public AggregateAnnotationCommandHandler<Organization> organizationCommandHandler() {
		@SuppressWarnings("unchecked")
		AggregateAnnotationCommandHandler<Organization> commandHandler = AggregateAnnotationCommandHandler.subscribe(Organization.class,
				organizationEventSourcingRepository(), commandBus());
		
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
