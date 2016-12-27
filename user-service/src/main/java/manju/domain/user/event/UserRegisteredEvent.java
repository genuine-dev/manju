package manju.domain.user.event;

import manju.domain.user.AvatarUrl;
import manju.domain.user.EmailAddress;
import manju.domain.user.UserId;

public class UserRegisteredEvent {
	private final UserId id;
	
	private final EmailAddress emailAddress;
	
	private final AvatarUrl avatarUrl;

	public UserRegisteredEvent(UserId id, EmailAddress emailAddress, AvatarUrl avatarUrl) {
		this.id = id;
		this.emailAddress = emailAddress;
		this.avatarUrl = avatarUrl;
	}
	
	public UserId getId() {
		return id;
	}
	
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}
	
	public AvatarUrl getAvatarUrl() {
		return avatarUrl;
	}
}
