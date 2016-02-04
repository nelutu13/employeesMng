package eu.isdc.employeesMng.controller;

import eu.isdc.employeesMng.service.UsersService;
import eu.isdc.employeesMng.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private UsersService userService;
    
    @RequestMapping("/users")
    public List<User> getUsers() {

    	return userService.getUsers();
        
    }

    @RequestMapping("/usersDetail")
    public ResponseEntity<User> getUser(@RequestParam(value="userNumber", defaultValue="0") String userNumber) {

    	User user = userService.getUser(Integer.parseInt(userNumber));
    	
    	if(user == null) {
    		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    	}

		return new ResponseEntity<User>(user,HttpStatus.OK);

    }

    
    
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User modifiedUser) {
    //public ResponseEntity<User> update(@RequestParam(value="userId", defaultValue="0") String userNumber, @RequestBody User modifiedUser) {

    	User updatedUser = userService.updateUser(modifiedUser);

    	if(updatedUser == null) {
    		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    	}

		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

    }

}
