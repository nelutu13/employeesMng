package eu.isdc.employeesMng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<User> getUsers() throws UserException {

    	return userService.getUsers();
        
    }

    
    
    @RequestMapping(value="/userDetail", method = RequestMethod.GET)
    public User getUser(@RequestParam(value="userId") String userId) throws UserException {

    	//validate mandatory field
        if(userId == null){					throw new UserException("id is not present in request !!");}
        
        try{Integer.parseInt(userId);}
        catch(NumberFormatException e) {	throw new UserException("id is not a number !!");}
        
        if(Integer.parseInt(userId) < 1){	throw new UserException("id is not valid !!");}

        return userService.getUser(Integer.parseInt(userId));
    	
    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User modifiedUser) throws UserException {
    //public ResponseEntity<User> update(@RequestParam(value="userId", defaultValue="0") String userId, @RequestBody User modifiedUser) {

    	User updatedUser = userService.updateUser(modifiedUser);

    	if(updatedUser == null) {
    		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    	}

		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

    }

}
