package de.bluexs.crtrip.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author daveyx
 * 
 */

@Data
@Entity
public class Intro {

	private @Id @GeneratedValue Long id;
	private String title;
	private List<String> texts;
	private String image;
	private String imageText;
	private List<String> images;
	
	@SuppressWarnings("unused")
	private Intro() {}

	public Intro(final String title, final List<String> texts, final String image, final String imageText, final List<String> images) {
		this.title = title;
		this.texts = texts;
		this.image = image;
		this.imageText = imageText;
		this.images = images;
	}
	
}
