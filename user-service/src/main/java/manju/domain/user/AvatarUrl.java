package manju.domain.user;

import org.hibernate.validator.constraints.NotEmpty;

public class AvatarUrl {
	@NotEmpty
	private final String value;

	public AvatarUrl(String value) {
		super();
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
