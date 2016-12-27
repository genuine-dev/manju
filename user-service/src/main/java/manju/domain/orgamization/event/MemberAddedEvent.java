package manju.domain.orgamization.event;

import manju.domain.orgamization.Member;
import manju.domain.orgamization.OrganizationId;

public class MemberAddedEvent {
	
	private final OrganizationId organizationId;

	private final Member member;

	public MemberAddedEvent(OrganizationId organizationId, Member member) {
		super();
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
