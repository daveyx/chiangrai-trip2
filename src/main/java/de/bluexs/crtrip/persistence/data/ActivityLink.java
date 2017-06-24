package de.bluexs.crtrip.persistence.data;

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
public class ActivityLink {

	@Id
	@GeneratedValue
	private Long id;

	private String link;
	private String linkText;
	private String linkDescLeft;
	private String linkDescRight;
	
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;
	
	public ActivityLink(
			final String link, 
			final String linkText,
			final String linkDescLeft,
			final String linkDescRight,
			final Activity activity) {
		this.link = link;
		this.linkText = linkText;
		this.linkDescLeft = linkDescLeft;
		this.linkDescRight = linkDescRight;
		this.activity = activity;
	}
}
