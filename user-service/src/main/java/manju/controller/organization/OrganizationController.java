package manju.controller.organization;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import manju.controller.organization.dto.RegisterOrganizationData;
import manju.domain.orgamization.Description;
import manju.domain.orgamization.DisplayName;
import manju.domain.orgamization.Name;
import manju.domain.orgamization.OrganizationId;
import manju.domain.orgamization.command.RegisterOrganizationCommand;
import manju.domain.user.UserId;
import manju.query.user.User;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

	@Autowired
	private OAuth2RestTemplate restTemplate;

	@Autowired
	private CommandGateway commandGateway;

	@RequestMapping(value="/new", method=RequestMethod.POST)
	public void register(RegisterOrganizationData data){
		User me = restTemplate.getForObject("http://user-service/me", User.class);
		
		commandGateway.send(new RegisterOrganizationCommand(
						new OrganizationId(),
						new Name(data.getName()),
						new DisplayName(data.getDisplayName()),
						new Description(data.getDescription()),
						new UserId(me.getId())
					)
				);
	}
}
