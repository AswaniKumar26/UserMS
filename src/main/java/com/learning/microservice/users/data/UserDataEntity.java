package com.learning.microservice.users.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserDataEntity implements Serializable {

	private static final long serialVersionUID = -6370600567339248934L;
	
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false,length=50)
	private String firstName;

	@Column(nullable=false,length=50)
	private String lastName;
	
	@Column(nullable=false,length=50,unique=true)
	private String userName;
	@Column(nullable=false,length=120,unique=true)
	private String email;
	
	@Column(nullable=false)
	private String encryptedPassword;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

}
