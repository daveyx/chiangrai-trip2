package de.bluexs.crtrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 
 * @author daveyx
 * 
 */

@SpringBootApplication
public class CrtripApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrtripApplication.class, args);
	}
}
