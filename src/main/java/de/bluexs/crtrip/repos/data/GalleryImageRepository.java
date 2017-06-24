package de.bluexs.crtrip.repos.data;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.bluexs.crtrip.persistence.data.GalleryImage;

/**
 * 
 * @author daveyx
 * 
 */

@RepositoryRestResource(exported = false)
public interface GalleryImageRepository extends Repository<GalleryImage, Long>{

	@PreAuthorize("hasAuthority('ADMIN')")
	GalleryImage save(final GalleryImage image);

	GalleryImage findById(final Long id);
	
}
