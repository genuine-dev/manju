package manju.domain.orgamization;

public class Description {

	private final String value;

	public Description(String value) {
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
