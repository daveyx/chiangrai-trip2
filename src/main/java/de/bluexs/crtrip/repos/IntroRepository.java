package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.data.Intro;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface IntroRepository extends Repository<Intro, Long> {

	Intro findById(final Long id);
	
	@PreAuthorize("hasAuthority('ADMIN')")
	Intro save(Intro intro);

}
