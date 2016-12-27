package manju.domain.orgamization.event;

import manju.domain.orgamization.OrganizationId;
import manju.domain.user.UserId;

public class MemberRemovedEvent {

	private final OrganizationId organizationId;

	private final UserId userId;

	public MemberRemovedEvent(OrganizationId organizationId, UserId userId) {
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
