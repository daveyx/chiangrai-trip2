package de.bluexs.crtrip.play;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Greeting {

	@Id
	@GeneratedValue
    private Long id;
	
    private Long fakeId;
    
    private String content;

    public Greeting(final String content, final long fakeId) {
        this.content = content;
        this.fakeId = fakeId;
    }
}
