package com.example.hibia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

import com.example.hibia.dto.UserForm;
import com.example.hibia.exception.DuplicateEmailException;
import com.example.hibia.repository.UserRepository;

import lombok.Getter;

@Entity
@Getter
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String userName;
	
	@Column(length = 50, nullable = false)
	private String passwd;
	
	public User() {}
	
	public User(UserForm userForm) {
		this.email = userForm.getEmail();
		this.userName = userForm.getUserName();
		this.passwd = userForm.getPasswd();
	}
	
	public static User createUser(UserForm userForm) {
		return new User(userForm);
	}
	
}
