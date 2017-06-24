package de.bluexs.crtrip.persistence.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
public class Intro {

	private @Id @GeneratedValue Long id;
	private String title;
	@ElementCollection(targetClass=String.class)
	@Column(length=10000)
	private List<String> texts;
	private String image;
	private String imageText;
	@ElementCollection(targetClass=String.class)
	@Column(length=10000)
	private List<String> images;

	public Intro(final String title, final List<String> texts, final String image, final String imageText, final List<String> images) {
		this.title = title;
		this.texts = texts;
		this.image = image;
		this.imageText = imageText;
		this.images = images;
	}
	
}
