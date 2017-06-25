package de.bluexs.crtrip.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.bluexs.crtrip.repos.UserRepository;

/**
 * 
 * @author daveyx
 * 
 */

@Component
public class UserDatabaseLoader implements CommandLineRunner {

	private final UserRepository users;

	@Autowired
	public UserDatabaseLoader(final UserRepository userRepository) {
		this.users = userRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		// $2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri
		// $2a$10$f16d85rMfM/fLFCEet/66ePGmw2O4qu1HnYRxFLYD64Yi77gD48Xu
		final User user1 = new User(null, "peter@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
		final User user2 = new User(null, "katie@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
		final User user3 = new User(null, "john@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
		
		users.save(user1);
		users.save(user2);
		users.save(user3);
	}
	
}
