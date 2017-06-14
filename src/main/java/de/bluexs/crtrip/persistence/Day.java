package de.bluexs.crtrip.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 
 * @author daveyx
 * 
 */

@Data
@Entity
@JsonInclude(Include.NON_NULL)
public class Day {

	private @Id @GeneratedValue Long id;
	private String title;
	private String subtitle;
	private String image;
	@OneToOne
	private Intro intro;
	
	@SuppressWarnings("unused")
	private Day() {}

	public Day(final String title, final String subtitle, final String image, final Intro intro) {
		this.title = title;
		this.subtitle = subtitle;
		this.image = image;
		this.intro = intro;
	}

}
