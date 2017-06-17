package de.bluexs.crtrip.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Activity {

	private @Id @GeneratedValue Long id;
	private String title;
	private String subtitle;
	@ElementCollection(targetClass=String.class)
	@Column(length=10000)
	private List<String> texts;
	private @ManyToOne Day day;

	public Activity(final String title, final String subtitle, final List<String> texts, final Day day) {
		this.title = title;
		this.subtitle = subtitle;
		this.texts = texts;
		this.day = day;
	}

}
