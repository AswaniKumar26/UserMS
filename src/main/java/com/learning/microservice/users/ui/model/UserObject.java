package com.learning.microservice.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserObject {
	
	@NotNull(message="First Name cannot be Null")
	@Size(min=3,message="First name should be minimum of 3 charecters")
	private String firstName;
	
	@NotNull(message="Last  Name cannot be Null")
	@Size(min=3,message="Last name should be minimum of 3 charecters")
	private String lastName;
	
	@NotNull(message="User Name cannot be Null")
	@Size(min=6,message="user Name should be minumum of 6 charecters")
	private String userName;
	
	@NotNull(message="Password cannot be Null")
	@Size(min=8,max=10,message="password should have minumum length of 8 charecters and maximun of 10 charecters")
	private String password;
	
	@NotNull(message="Email cannot be Null")
	@Email
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
