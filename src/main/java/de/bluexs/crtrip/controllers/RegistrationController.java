package de.bluexs.crtrip.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.bluexs.crtrip.persistence.User;
import de.bluexs.crtrip.service.IUserService;
import de.bluexs.crtrip.util.GenericResponse;
import de.bluexs.crtrip.util.UserDto;

/**
 * 
 * @author daveyx
 * 
 */

@RestController
public class RegistrationController {
	
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
        LOGGER.debug("Registering user account with information: {}", accountDto);

        @SuppressWarnings("unused")
		final User registered = userService.registerNewUserAccount(accountDto);
        return new GenericResponse("success");
    }

}
