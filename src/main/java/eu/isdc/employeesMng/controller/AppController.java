package eu.isdc.employeesMng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import eu.isdc.employeesMng.service.UsersService;
import eu.isdc.employeesMng.model.User;
import eu.isdc.employeesMng.exception.UserException;

@RestController
public class AppController {

    @Autowired
    private UsersService userService;
    
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> read() throws UserException {

    	return userService.read();
        
    }

    
    
    @RequestMapping(value="/userDetail", method = RequestMethod.GET)
    public User getUser(@RequestParam(value="userId") String userId) throws UserException {

        userService.validateUserId(userId);

        return userService.getUser(Integer.parseInt(userId));
    	
    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public User create(@RequestBody User proposedUser) throws UserException {

        return userService.create(proposedUser);

    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.PUT)
    public User update(@RequestParam(value="userId") String userId, @RequestBody User modifiedUser) throws UserException {

        userService.validateUserId(userId);
        
        return userService.update(Integer.parseInt(userId), modifiedUser);

    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value="userId") String userId) throws UserException {

        userService.validateUserId(userId);

        return userService.delete(Integer.parseInt(userId));
        //return false;

    }

    
}
