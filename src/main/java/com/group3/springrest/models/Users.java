package com.group3.springrest.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
	
	private Integer userId;
	private String fName;
	private String lName;
	private String email;
	private String username;
	private String passWord;
	
	public Users() {
		
	}
	
	public Users(String fName, String lName, String email, String username) {
		this.fName = fName; 
		this.lName = lName;
		this.email = email;
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "fName", nullable = false)
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Column(name = "lName", nullable = false)
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "pass_word", nullable = false)
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
