package de.bluexs.crtrip.persistence;

import org.springframework.data.repository.Repository;

/**
 * 
 * @author daveyx
 * 
 */

public interface IntroRepository extends Repository<Intro, Long> {

	Intro findById(final Long id);

	Intro save(Intro intro);

}
