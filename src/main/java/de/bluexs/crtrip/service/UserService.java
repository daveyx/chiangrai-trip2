package de.bluexs.crtrip.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bluexs.crtrip.persistence.User;
import de.bluexs.crtrip.repos.UserRepository;
import de.bluexs.crtrip.util.UserDto;

/**
 * 
 * @author daveyx
 * 
 */

@Service
@Transactional
public class UserService implements IUserService {
	
    @Autowired
    private UserRepository repository;

	public User registerNewUserAccount(final UserDto userDto) {
		
        if (emailExist(userDto.getEmail())) {
            throw new IllegalStateException("There is an account with that email adress: " + userDto.getEmail());
        }
        final User user = new User();

        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
//        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER"))); ---> for later use
        return repository.save(user);
	}
	
	
	//
	// ---> private
	//

	
    private boolean emailExist(final String email) {
        return repository.findByEmail(email) != null;
    }
}
