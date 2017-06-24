package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.data.Gallery;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface GalleryRepository extends Repository<Gallery, Long>{

	@PreAuthorize("hasAuthority('ADMIN')")
	Gallery save(final Gallery gallery);

	Gallery findById(final Long id);
	
}
