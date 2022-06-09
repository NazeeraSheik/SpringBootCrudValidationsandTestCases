package com.springbootcrud.validation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.validation.model.User;
import com.springbootcrud.validation.service.UserService;

@RestController

public class UserController {
	
	  @Autowired
	  private UserService userService;
	  
	  @RequestMapping("/users")
		public List<User> getAllUsers(){
			return userService.getAllUsers();
			
		}
		
	  
	  @RequestMapping(method=RequestMethod.POST,value="/users") 
      public void createUser(@Valid @RequestBody User user){
    	   userService.createUser(user);
	  }
	  @RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
		public void updateUser(@PathVariable long id,@RequestBody User user) {
		   			userService.updateUser(id,user);
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
		public void deleteUser(@PathVariable long id) {
			userService.deleteUser(id);
		}
	  
}
