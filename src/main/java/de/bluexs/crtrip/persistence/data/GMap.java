package de.bluexs.crtrip.persistence.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class GMap {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String lng;
	private String lat;
	private String zoom;
	
	public GMap(
			final String title,
			final String lng,
			final String lat,
			final String zoom) {
		this.title = title;
		this.lng = lng;
		this.lat = lat;
		this.zoom = zoom;
	}

}
