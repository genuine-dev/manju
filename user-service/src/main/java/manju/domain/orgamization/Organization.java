package manju.domain.orgamization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import manju.domain.orgamization.command.AddMemberCommand;
import manju.domain.orgamization.command.RegisterOrganizationCommand;
import manju.domain.orgamization.command.RemoveMemberCommand;
import manju.domain.orgamization.event.MemberAddedEvent;
import manju.domain.orgamization.event.MemberRemovedEvent;
import manju.domain.orgamization.event.OrganizationRegisteredEvent;
import manju.domain.user.UserId;

public class Organization extends AbstractAnnotatedAggregateRoot<OrganizationId>{
	
	@AggregateIdentifier
	private OrganizationId id;
	
	private Name name;
	
	private DisplayName displayName;
	
	private Description description;
	
	private Map<UserId, Member> members;
	
	@SuppressWarnings("unused")
	private Organization(){}

	@CommandHandler
	public Organization(RegisterOrganizationCommand command) {
		
		apply(new OrganizationRegisteredEvent(
					command.getId(),
					command.getName(),
					command.getDisplayName(),
					command.getDescription(),
					command.getOwner()
				)
		);
	}
	
	@CommandHandler
	public void addMember(AddMemberCommand command){
		apply(new MemberAddedEvent(command.getOrganizationId(), command.getMember()));
	}
	
	@CommandHandler
	public void removeMember(RemoveMemberCommand command){
		apply(new MemberRemovedEvent(command.getOrganizationId(), command.getUserId()));
	}
	
	@EventHandler
	public void on(OrganizationRegisteredEvent event){
		this.id = event.getId();
		this.name = event.getName();
		this.displayName = event.getDisplayName();
		this.description = event.getDescription();
		this.members = new LinkedHashMap<>();
		members.put(event.getOwner().getId(), event.getOwner());
	}
	
	@EventHandler
	public void on(MemberAddedEvent event){
		this.members.put(event.getMember().getId(), event.getMember());
	}
	
	public void on(MemberRemovedEvent event){
		this.members.remove(event.getUserId());
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

	public List<Member> getMembers() {
		return Collections.unmodifiableList(new ArrayList<Member>(members.values()));
	}
}
