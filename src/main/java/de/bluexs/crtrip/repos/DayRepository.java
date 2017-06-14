package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.Day;

/**
 * 
 * @author daveyx
 * 
 */

public interface DayRepository extends Repository<Day, Long> {

	Day findById(final Long id);
	Day findOne(Long id);
	Iterable<Day> findAll();

	@PreAuthorize("hasAuthority('ADMIN')")
	Day save(Day day);

}
