package manju.domain.user;

import org.hibernate.validator.constraints.NotEmpty;

public class EmailAddress {
	@NotEmpty
	private final String value;

	public EmailAddress(String value) {
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
