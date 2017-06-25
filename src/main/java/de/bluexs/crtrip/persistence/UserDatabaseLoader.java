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
		final User user1 = new User(null, "peter@example.com", "password");
		final User user2 = new User(null, "katie@example.com", "password");
		final User user3 = new User(null, "john@example.com", "password");
		
		users.save(user1);
		users.save(user2);
		users.save(user3);
	}
	
}
