package manju.controller.user;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import manju.domain.user.AvatarUrl;
import manju.domain.user.EmailAddress;
import manju.domain.user.UserId;
import manju.domain.user.command.RegisterUserCommand;
import manju.query.organization.OrganizationMember;
import manju.query.organization.OrganizationMemberRepository;
import manju.query.user.User;
import manju.query.user.UserRepository;

@RestController
public class UserContorller {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrganizationMemberRepository organizationMemberRepository;
	
	@Autowired
	private CommandGateway commandGateway;


	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public User me(OAuth2Authentication principal) {
		@SuppressWarnings("unchecked")
		Map<String, String> details = (Map<String, String>) principal.getUserAuthentication().getDetails();
		
		String id = details.get("id");
		return userRepository.findOne(id);
	}

	@RequestMapping(value = "/me/groups", method = RequestMethod.GET)
	public List<String> myGroups(OAuth2Authentication principal) {
		@SuppressWarnings("unchecked")
		Map<String, String> details = (Map<String, String>) principal.getUserAuthentication().getDetails();
		
		String id = details.get("id");
		List<String> groups = organizationMemberRepository.findByPkUserId(id).stream()
			.map(organizationMember -> organizationMember.getOrganizationId().toString())
			.collect(Collectors.toList());
		groups.add("ALL");
		return groups;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String registerUser(OAuth2Authentication principal){
		@SuppressWarnings("unchecked")
		Map<String, String> details = (Map<String, String>) principal.getUserAuthentication().getDetails();
		
		RegisterUserCommand command = new RegisterUserCommand(
											new UserId(details.get("id")), 
											new EmailAddress(details.get("email")),
											new AvatarUrl(details.get("picture"))
										);
		commandGateway.send(command);
		
		return "{\"registered\": true}";
	}
	
}
