package manju.controller.article.dto;

public class User {
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
