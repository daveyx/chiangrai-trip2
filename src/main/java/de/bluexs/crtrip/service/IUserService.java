package de.bluexs.crtrip.service;

import de.bluexs.crtrip.persistence.User;
import de.bluexs.crtrip.util.UserDto;

/**
 * 
 * @author daveyx
 * 
 */

public interface IUserService {

	User registerNewUserAccount(final UserDto accountDto);

}
