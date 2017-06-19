package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.bluexs.crtrip.persistence.GalleryImage;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface GalleryImageRepository extends Repository<GalleryImage, Long>{

	GalleryImage save(final GalleryImage gallery);

	GalleryImage findById(final Long id);
	
}
