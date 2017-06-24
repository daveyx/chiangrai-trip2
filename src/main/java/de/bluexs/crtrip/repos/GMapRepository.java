package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.data.GMap;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface GMapRepository extends Repository<GMap, Long>{

	@PreAuthorize("hasAuthority('ADMIN')")
	GMap save(GMap link);

	GMap findById(Long id);
	
}