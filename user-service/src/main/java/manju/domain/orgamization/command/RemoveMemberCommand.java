package manju.domain.orgamization.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import manju.domain.orgamization.OrganizationId;
import manju.domain.user.UserId;

public class RemoveMemberCommand {

	@NotNull
	@TargetAggregateIdentifier
	private final  OrganizationId organizationId;

	@NotNull
	@Valid
	private final UserId userId;

	public RemoveMemberCommand(OrganizationId organizationId, UserId userId) {
		super();
		this.organizationId = organizationId;
		this.userId = userId;
	}

	public OrganizationId getOrganizationId() {
		return organizationId;
	}

	public UserId getUserId() {
		return userId;
	}
}
