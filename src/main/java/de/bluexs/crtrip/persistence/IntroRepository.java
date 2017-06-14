package de.bluexs.crtrip.persistence;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface IntroRepository extends Repository<Intro, Long> {

	Intro findById(final Long id);
	Intro save(Intro intro);

}
