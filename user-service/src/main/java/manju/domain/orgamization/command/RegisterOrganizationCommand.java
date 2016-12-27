package manju.domain.orgamization.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import manju.domain.orgamization.Description;
import manju.domain.orgamization.DisplayName;
import manju.domain.orgamization.Member;
import manju.domain.orgamization.MemberRole;
import manju.domain.orgamization.Name;
import manju.domain.orgamization.OrganizationId;
import manju.domain.user.UserId;

public class RegisterOrganizationCommand {
	@NotNull
	@Valid
	@TargetAggregateIdentifier
	private final OrganizationId id;
	
	@NotNull
	@Valid
	private final Name name;
	
	private final DisplayName displayName;
	
	private final Description description;
	
	private final Member owner;

	public RegisterOrganizationCommand(OrganizationId id, Name name, DisplayName displayName, Description description, UserId owner) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.owner = new Member(owner, MemberRole.ADMINISTRATOR);
		
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
