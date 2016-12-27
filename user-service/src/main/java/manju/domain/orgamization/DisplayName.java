package manju.domain.orgamization;

import org.hibernate.validator.constraints.NotEmpty;

public class DisplayName {
	@NotEmpty
	private final String value;

	public DisplayName(String value) {
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
