package eu.isdc.employeesMng.controller;

import eu.isdc.employeesMng.service.UsersService;
import eu.isdc.employeesMng.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private UsersService userService;
    
    @RequestMapping("/users")
    public String getUsers() {
    	return userService.getUsers();
        
    }

    @RequestMapping("/usersDetail")
    public User getUser(@RequestParam(value="number", defaultValue="0") String number) {
        return new User(number, "Ion Baciu");
    }

}