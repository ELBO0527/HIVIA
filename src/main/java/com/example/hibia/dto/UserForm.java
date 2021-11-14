package com.example.hibia.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {

	
	@Column
	private String email;
	
	@Column
	private String userName;
	
	@Column
	private String passwd;
}
