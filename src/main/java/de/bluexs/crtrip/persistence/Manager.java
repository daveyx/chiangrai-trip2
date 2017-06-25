
package de.bluexs.crtrip.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author daveyx
 * 
 */

@Data
@ToString(exclude = "password")
@Entity
@NoArgsConstructor
public class Manager {

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@JsonIgnore
	private String password;

	private String[] roles;

	public void setPassword(final String password) {
		this.password = PASSWORD_ENCODER.encode(password);
	}

	public Manager(final String name, final String password, final String... roles) {

		this.name = name;
		this.setPassword(password);
		this.roles = roles;
	}

}
