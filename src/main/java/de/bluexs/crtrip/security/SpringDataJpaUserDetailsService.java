package de.bluexs.crtrip.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import de.bluexs.crtrip.repos.UserRepository;

/**
 * 
 * @author daveyx
 * 
 */

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public SpringDataJpaUserDetailsService(final UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		return repository.findByEmail(email);
	}

}
