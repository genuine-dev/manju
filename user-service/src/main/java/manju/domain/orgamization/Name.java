package manju.domain.orgamization;

import org.hibernate.validator.constraints.NotEmpty;

public class Name {
	@NotEmpty
	private final String value;

	public Name(String value) {
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
