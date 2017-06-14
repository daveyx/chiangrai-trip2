package de.bluexs.crtrip.restrepos;

import org.springframework.data.repository.Repository;

import de.bluexs.crtrip.persistence.Day;

/**
 * 
 * @author daveyx
 * 
 */

public interface DayRepository extends Repository<Day, Long> {

	Day findById(final Long id);

}
