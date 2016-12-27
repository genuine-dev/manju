package manju.query.organization;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manju.domain.orgamization.event.MemberAddedEvent;
import manju.domain.orgamization.event.MemberRemovedEvent;
import manju.domain.orgamization.event.OrganizationRegisteredEvent;

@Component
public class OrganizationEventHandler {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private OrganizationMemberRepository organizationMemberRepository;
	
	@EventHandler
	public void onOrganizationRegistered(OrganizationRegisteredEvent event){
		Organization organization = new Organization(
					event.getId().getValue(),
					event.getName().getValue(),
					event.getDisplayName().getValue(),
					event.getDescription().getValue()
				);
		organizationRepository.save(organization);
	}
	
	@EventHandler
	public void onMemberAdded(MemberAddedEvent event){
		OrganizationMember member = new OrganizationMember(
				event.getOrganizationId().getValue(),
				event.getMember().getId().getValue(),
				event.getMember().getRole().toString()
			);		
		organizationMemberRepository.save(member);
	}
	
	@EventHandler
	public void onMemberRemoved(MemberRemovedEvent event){
		organizationMemberRepository.delete(new OrganizationMember.PrimaryKey(
				event.getOrganizationId().getValue(), 
				event.getUserId().getValue()));
	}
}
