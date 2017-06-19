package de.bluexs.crtrip.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author daveyx
 * 
 */

@Data
@Entity
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Gallery {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	
	@OneToMany(mappedBy = "gallery")
    private List<GalleryImage> gallery;
	
	public Gallery(final String title) {
		this.title = title;
	}
}
