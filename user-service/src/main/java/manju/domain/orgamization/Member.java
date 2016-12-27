package manju.domain.orgamization;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import manju.domain.user.UserId;

public class Member {
	@NotNull
	@Valid
	private final UserId id;
	
	@NotNull
	private final MemberRole role;

	public Member(UserId id, MemberRole role) {
		this.id = id;
		this.role = role;
	}
	
	public UserId getId() {
		return id;
	}
	
	public MemberRole getRole() {
		return role;
	}
	
}
