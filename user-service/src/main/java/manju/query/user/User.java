package manju.query.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String id;
	
	private String emailAddress;
	
	private String avatarUrl;

	@SuppressWarnings("unused")
	private User() {
	}

	public User(String id, String emailAddress, String avatarUrl) {
		this.id = id;
		this.emailAddress = emailAddress;
		this.avatarUrl = avatarUrl;
	}

	public String getId() {
		return id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}
}
