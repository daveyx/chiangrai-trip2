package de.bluexs.crtrip.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 
 * @author daveyx
 * 
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	// avoid "Invalid token does not contain resource id (none)"
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(null);
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .anonymous().and()
        .authorizeRequests()
        .antMatchers("/greeting*", "/oauth/token").permitAll()
        .antMatchers("/api/**").authenticated();
    }

}
