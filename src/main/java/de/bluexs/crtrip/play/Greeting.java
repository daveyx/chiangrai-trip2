package de.bluexs.crtrip.play;

import javax.persistence.Entity;

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

    private long id;
    private String content;

    public Greeting(final long id, final String content) {
        this.id = id;
        this.content = content;
    }
}
