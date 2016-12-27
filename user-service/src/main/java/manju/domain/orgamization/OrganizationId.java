package manju.domain.orgamization;

import java.util.UUID;

public class OrganizationId {
	private UUID value;
	
	public OrganizationId(){
		this.value = UUID.randomUUID();
	}
	
	public OrganizationId(UUID id){
		this.value = id;
	}
	
	public UUID getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
