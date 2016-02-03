package eu.isdc.employeesMng.controller;

import eu.isdc.employeesMng.service.UsersService;
import eu.isdc.employeesMng.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/users")
    public ResponseEntity<User> createUser(@RequestParam(value="user", defaultValue="{}") User newUser) {

    	User user = userService.createUser(newUser);

    	if(user == null) {
    		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    	}

		return new ResponseEntity<User>(user,HttpStatus.OK);

    }

}
