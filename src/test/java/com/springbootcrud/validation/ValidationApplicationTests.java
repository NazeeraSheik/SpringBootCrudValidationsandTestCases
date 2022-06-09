package com.springbootcrud.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbootcrud.validation.model.User;
import com.springbootcrud.validation.repository.UserRepository;
import com.springbootcrud.validation.service.UserService;

@SpringBootTest
class ValidationApplicationTests {

	
	@Autowired
	private UserRepository repository;
   
	@MockBean
	private UserService service;
	
	User user1=new User("smith","smith@gmail.com","smith@123");
	User user2=new User("smitha","smitha@gmail.com","smitha@123");
	User user3=new User("smiths","smiths@gmail.com","smiths@123");
	
	
	@Test
	public void saveTest() {
		repository.save(user1);
	 Assertions.assertThat(user1.getEmail()).isEqualTo("smith@gmail.com");
		}
	
    @Test
   public void getTest() {
    	List<User> users=repository.findAll();
   	Assertions.assertThat(users.size()).isGreaterThan(0);
    }

   
    @Test
    public void updateTest() {
    	User user=repository.findById(14L).get();
    	user.setEmail("nazeera@gmail.com");
    	User userUpdated=repository.save(user);
    	Assertions.assertThat(userUpdated.getEmail()).isEqualTo("nazeera@gmail.com");
    }
	
    
    @Test
    public void deleteTest() {
    	User user=repository.findById(18L).get();
    	repository.delete(user);
    	User user1=null;
    	Optional<User> userExpected=repository.findById(18L);
    	if(userExpected.isPresent()) {
    		user1=userExpected.get();
    	}
    	Assertions.assertThat(user1).isNull();
    	
    }
    
    
	
	
}