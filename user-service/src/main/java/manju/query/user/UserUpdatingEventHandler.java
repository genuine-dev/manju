package manju.query.user;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manju.domain.user.event.UserRegisteredEvent;

@Component
public class UserUpdatingEventHandler {
	@Autowired
	private UserRepository userRepository;
	
	@EventHandler
	public void onRegister(UserRegisteredEvent event){
		User user = new User(
				event.getId().getValue(),
				event.getEmailAddress().getValue(),
				event.getAvatarUrl().getValue()
			);
		userRepository.save(user);
	}
}
