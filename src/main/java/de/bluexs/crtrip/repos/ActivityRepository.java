package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.Activity;
import de.bluexs.crtrip.persistence.Day;

/**
 * 
 * @author daveyx
 * 
 */

public interface ActivityRepository extends Repository<Activity, Long> {
	
	Activity findByDay(final Day day);

	@PreAuthorize("hasAuthority('ADMIN')")
	Activity save(Activity Activity);

}
