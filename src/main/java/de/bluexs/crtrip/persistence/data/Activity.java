package de.bluexs.crtrip.persistence.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Activity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String subtitle;
	
	@ElementCollection(targetClass=String.class)
	@Column(length=10000)
	private List<String> texts;
	
	@OneToOne
	private GMap gMap;
	
	@OneToOne
	private Gallery gallery;
	
	@ManyToOne
	@JoinColumn(name="day_id")
	private Day day;
	
	@OneToMany(mappedBy = "activity")
    private List<ActivityLink> activityLinks;
	
	public Activity(
			final String title, 
			final String subtitle, 
			final List<String> texts, 
			final GMap gMap,
			final Gallery gallery,
			final Day day) {
		this.title = title;
		this.subtitle = subtitle;
		this.texts = texts;
		this.gMap = gMap;
		this.gallery = gallery;
		this.day = day;
	}

}
