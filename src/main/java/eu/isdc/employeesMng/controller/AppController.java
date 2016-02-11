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
    

    
    @RequestMapping(value="/usersPaginationCount", method = RequestMethod.GET)
    public int usersPaginationCount() throws UserException {

    	return userService.usersPaginationCount();
        
    }
    
    
    
    @RequestMapping(value="/usersPagination", method = RequestMethod.GET)
    public List<User> read(@RequestParam(value="firstrow") String firstrow, @RequestParam(value="pageSize") String pageSize) throws UserException {

        userService.validateRequestParam(firstrow, "firstrow");
        userService.validateRequestParam(pageSize, "pageSize");

        return userService.read(Integer.parseInt(firstrow), Integer.parseInt(pageSize));
    	
    }
    
    
    
    @RequestMapping(value="/userDetail", method = RequestMethod.GET)
    public User readUser(@RequestParam(value="userId") String userId) throws UserException {

        userService.validateRequestParam(userId, "userId");

        return userService.readUser(Integer.parseInt(userId));
    	
    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public int create(@RequestBody User proposedUser) throws UserException {

        return userService.create(proposedUser);

    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.PUT)
    public int update(@RequestParam(value="userId") String userId, @RequestBody User modifiedUser) throws UserException {

        userService.validateRequestParam(userId, "userId");
        
        return userService.update(Integer.parseInt(userId), modifiedUser);

    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value="userId") String userId) throws UserException {

        userService.validateRequestParam(userId, "userId");

        return userService.delete(Integer.parseInt(userId));

    }

    
}
