package manju.domain.user.command;

import static org.junit.Assert.assertNotNull;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import manju.domain.user.AvatarUrl;
import manju.domain.user.EmailAddress;
import manju.domain.user.UserId;
import manju.query.user.User;
import manju.query.user.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterCommandTest {
	@Autowired
	CommandGateway commandGateway;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testRegisterUser(){
		RegisterUserCommand command = new RegisterUserCommand(
					new UserId("test2"),
					new EmailAddress("test@example.com"),
					new AvatarUrl("http://example.com/avater.png")
				);
		UserId id  =  commandGateway.sendAndWait(command);
		
		User user = userRepository.findOne(id.getValue());
		
		assertNotNull(user);
		
	}
}
