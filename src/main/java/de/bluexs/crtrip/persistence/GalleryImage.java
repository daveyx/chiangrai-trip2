package de.bluexs.crtrip.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class GalleryImage {

	@Id
	@GeneratedValue
	private Long id;

	private String original;
	private String thumbnail;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;
	
	public GalleryImage(
			final String original, 
			final String thumbnail, 
			final String description,
			final Activity activity) {
		this.original = original;
		this.thumbnail = thumbnail;
		this.description = description;
		this.activity = activity;
	}
}
