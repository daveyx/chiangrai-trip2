package de.bluexs.crtrip.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author daveyx
 * 
 */

@RestController
public class RegistrationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
//    @ResponseBody
//    public GenericResponse registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
//        LOGGER.debug("Registering user account with information: {}", accountDto);
//
//        final User registered = userService.registerNewUserAccount(accountDto);
//        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
//        return new GenericResponse("success");
//    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") final String name) {
        return new Greeting(counter.incrementAndGet(),
        		String.format(template, name));        
    }
}

