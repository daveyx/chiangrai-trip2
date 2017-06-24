package de.bluexs.crtrip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.bluexs.crtrip.persistence.User;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneByUsername(final String username);
	
}
