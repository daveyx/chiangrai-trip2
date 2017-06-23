package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.Manager;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface ManagerRepository extends Repository<Manager, Long> {

	@PreAuthorize("hasAuthority('ADMIN')")
	Manager save(Manager manager);

	Manager findByName(String name);

}
