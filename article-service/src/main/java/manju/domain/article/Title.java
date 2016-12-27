package manju.domain.article;

import org.hibernate.validator.constraints.NotEmpty;

public class Title {
	@NotEmpty
	private final String value;

	public Title(String value) {
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
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return value.equals(obj);
	}
}