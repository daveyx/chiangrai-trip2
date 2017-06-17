package de.bluexs.crtrip;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import de.bluexs.crtrip.persistence.Activity;

/**
 * 
 * @author daveyx
 * 
 */

//https://stackoverflow.com/questions/24839760/spring-boot-responsebody-doesnt-serialize-entity-id

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Activity.class);
    }
}
