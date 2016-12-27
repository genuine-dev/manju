package manju.domain.orgamization.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import manju.domain.orgamization.Member;
import manju.domain.orgamization.OrganizationId;

public class AddMemberCommand {
	@NotNull
	@TargetAggregateIdentifier
	private final OrganizationId organizationId;
	
	@NotNull
	@Valid
	private final Member member;

	
	public AddMemberCommand(OrganizationId organizationId, Member member) {
		this.organizationId = organizationId;
		this.member = member;
	}

	public OrganizationId getOrganizationId() {
		return organizationId;
	}

	public Member getMember() {
		return member;
	}
}
