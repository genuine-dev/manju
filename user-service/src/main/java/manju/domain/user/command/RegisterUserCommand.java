package manju.domain.user.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import manju.domain.user.AvatarUrl;
import manju.domain.user.EmailAddress;
import manju.domain.user.UserId;

public class RegisterUserCommand {
	@Valid
	@NotNull
	@TargetAggregateIdentifier
	private final UserId id;
	
	@Valid
	@NotNull
	private final EmailAddress emailAddress;
	
	@Valid
	@NotNull
	private final AvatarUrl avatarURL;

	public RegisterUserCommand(UserId id, EmailAddress emailAddress, AvatarUrl avatarURL) {
		this.id = id;
		this.emailAddress = emailAddress;
		this.avatarURL = avatarURL;
	}
	
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
