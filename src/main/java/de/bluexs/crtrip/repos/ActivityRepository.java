package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.Activity;

/**
 * 
 * @author daveyx
 * 
 */

public interface ActivityRepository extends Repository<Activity, Long> {

	Activity findById(final Long id);
	Activity findOne(Long id);
	Iterable<Activity> findAll();
	
	@PreAuthorize("hasAuthority('ADMIN')")
	Activity save(Activity Activity);

}
