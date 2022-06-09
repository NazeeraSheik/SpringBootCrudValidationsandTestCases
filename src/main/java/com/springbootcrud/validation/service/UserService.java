package com.springbootcrud.validation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.validation.model.User;
import com.springbootcrud.validation.repository.UserRepository;

@Service
public class UserService {
	
   @Autowired
   private UserRepository userRepository;
   
   
   public List<User> getAllUsers(){
		  
		  List<User> users=new ArrayList<>();   
		  userRepository.findAll().forEach(users::add);
		  return users;
	  }
   
   
   public User createUser(User user) {
	   return userRepository.save(user);  
			   
   }
   
 
   
   public User getUserById(long id) {
	   return userRepository.findById(id).orElse(null);
   }
   public User updateUser(long id,User user) {
	   User usr=userRepository.findById(id).get();
	   usr.setName(user.getName());
	   usr.setEmail(user.getEmail());
	   usr.setPassword(user.getPassword());
	   return userRepository.save(usr);
	   
	  }
   
   public void deleteUser(long id) {
		  userRepository.deleteById(id);
	  }
   
   
}
