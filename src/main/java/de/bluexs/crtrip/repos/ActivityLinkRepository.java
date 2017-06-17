package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.bluexs.crtrip.persistence.ActivityLink;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface ActivityLinkRepository extends Repository<ActivityLink, Long>{

	ActivityLink save(ActivityLink link);

	ActivityLink findById(Long id);
	
}
