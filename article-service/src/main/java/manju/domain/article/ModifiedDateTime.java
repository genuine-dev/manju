package manju.domain.article;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.validator.constraints.NotEmpty;

public class ModifiedDateTime {
	@NotEmpty
	private final LocalDateTime value;

	public ModifiedDateTime(LocalDateTime value) {
		this.value = value;
	}
	
	public LocalDateTime getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
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
