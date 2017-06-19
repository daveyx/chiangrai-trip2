package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.bluexs.crtrip.persistence.Gallery;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface GalleryRepository extends Repository<Gallery, Long>{

	Gallery save(final Gallery gallery);

	Gallery findById(final Long id);
	
}
