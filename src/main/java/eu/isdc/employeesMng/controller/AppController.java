package eu.isdc.employeesMng.controller;

import eu.isdc.employeesMng.service.UsersService;
import eu.isdc.employeesMng.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static final String template = "Hello, %s!";

    @Autowired
    private UsersService userService;
    
    @RequestMapping("/getUser")
    public User getUser(@RequestParam(value="name", defaultValue="you") String name) {
        return new User(String.format(template, name));
    }

    @RequestMapping("/users")
    public String getUsers() {
    	return userService.getUsers();
        
    }

}