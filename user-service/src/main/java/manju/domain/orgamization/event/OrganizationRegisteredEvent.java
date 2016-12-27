package manju.domain.orgamization.event;

import manju.domain.orgamization.Description;
import manju.domain.orgamization.DisplayName;
import manju.domain.orgamization.Member;
import manju.domain.orgamization.Name;
import manju.domain.orgamization.OrganizationId;

public class OrganizationRegisteredEvent {
	private final OrganizationId id;
	
	private final Name name;
	
	private final DisplayName displayName;
	
	private final Description description;
	
	private final Member owner;

	public OrganizationRegisteredEvent(OrganizationId id, Name name, DisplayName displayName, Description description,
			Member owner) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.owner = owner;
	}
	
	public OrganizationId getId() {
		return id;
	}
	
	public Name getName() {
		return name;
	}
	
	public DisplayName getDisplayName() {
		return displayName;
	}
	
	public Description getDescription() {
		return description;
	}
	
	public Member getOwner() {
		return owner;
	}
	
	
}
