package de.bluexs.crtrip.play;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * 
 * @author daveyx
 * 
 */

@Component
public class GreetingDatabaseLoader implements CommandLineRunner {

	private final GreetingRepo greetings;

	@Autowired
	public GreetingDatabaseLoader(final GreetingRepo greetingRepository) {
		this.greetings = greetingRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		final Greeting greeting1 = new Greeting("peter@example.com", 88l);
		final Greeting greeting2 = new Greeting("katie@example.com", 88l);
		final Greeting greeting3 = new Greeting("john@example.com", 88l);
		
		greetings.save(greeting1);
		greetings.save(greeting2);
		greetings.save(greeting3);
	}
	
}
