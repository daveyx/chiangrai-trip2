package de.bluexs.crtrip.play;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author daveyx
 * 
 */

public interface GreetingRepo extends JpaRepository<Greeting, Long> {

}
