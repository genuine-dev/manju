package manju.domain.user;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import manju.domain.user.command.RegisterUserCommand;
import manju.domain.user.event.UserRegisteredEvent;

public class User extends AbstractAnnotatedAggregateRoot<UserId>{

	private static final long serialVersionUID = 383291627642162624L;

	@AggregateIdentifier
	private UserId id;
	
	private EmailAddress emailAddress;
	
	private AvatarUrl avatarURL;

	@CommandHandler
	public User(RegisterUserCommand command){
		apply(new UserRegisteredEvent(command.getId(),command.getEmailAddress(), command.getAvatarURL()));
	}
	
	@EventHandler
	public void on(UserRegisteredEvent event){
		this.id = event.getId();
		this.emailAddress = event.getEmailAddress();
		this.avatarURL = event.getAvatarUrl();
	}
	
	@SuppressWarnings("unused")
	private User(){}
	
	public UserId getId() {
		return id;
	}
	
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}
	
	public AvatarUrl getAvatarURL() {
		return avatarURL;
	}

	
	
}
