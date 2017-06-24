package de.bluexs.crtrip.persistence.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Day {

	private @Id @GeneratedValue Long id;
	
	private String title;
	private String subtitle;
	private String image;
	
	@OneToOne
	private Intro intro;
	
	@OneToMany(mappedBy = "day")
    private List<Activity> activities;

	public Day(final String title, final String subtitle, final String image, final Intro intro) {
		this.title = title;
		this.subtitle = subtitle;
		this.image = image;
		this.intro = intro;
	}

}
