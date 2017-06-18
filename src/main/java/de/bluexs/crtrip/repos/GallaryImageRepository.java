package de.bluexs.crtrip.repos;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.bluexs.crtrip.persistence.GallaryImage;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface GallaryImageRepository extends Repository<GallaryImage, Long>{

	GallaryImage save(final GallaryImage image);

	GallaryImage findById(final Long id);
	
}
