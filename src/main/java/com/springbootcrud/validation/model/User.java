package com.springbootcrud.validation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Table(name="users")
@Entity

public class User {
	
	
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
 
 @Column(name="name",nullable=false)
 @NotEmpty
 @Size(min=4,message="User name should be atleast 2 characters")
 private String name;
 
 @NotEmpty
 @Email
 private String email;
 
 @NotEmpty
 @Size(min=8,message="password should have atleast 8 characters")
 private String password;
 
 public User() {
	
 }
 
public User( String name, String email, String password) {
	super();
	
	this.name = name;
	this.email = email;
	this.password = password;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 
 
}
