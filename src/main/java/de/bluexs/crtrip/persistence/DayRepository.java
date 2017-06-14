package de.bluexs.crtrip.persistence;

import org.springframework.data.repository.Repository;

/**
 * 
 * @author daveyx
 * 
 */

public interface DayRepository extends Repository<Day, Long> {

	Day findById(final Long id);

	Day save(Day day);

}