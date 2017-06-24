package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.data.ActivityLink;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface ActivityLinkRepository extends Repository<ActivityLink, Long>{

	@PreAuthorize("hasAuthority('ADMIN')")
	ActivityLink save(ActivityLink link);

	ActivityLink findById(Long id);
	
}
