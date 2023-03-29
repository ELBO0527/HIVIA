package com.example.hibia.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column
	private String passwd;

	@Column(columnDefinition = "integer default 0")
	private int balance;

	@Column
	private LocalDate birthday;

	@Column
	private String mobile;

	@OneToOne(mappedBy = "user")
	private Address address;

	@OneToOne(mappedBy = "user")
	private Cart cart;

	@Column
	private String profile_url;

	@Column(length = 100)
	private String provider;

	@ElementCollection(fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>();

	@Builder
	public User(Long id, String email, String username, String passwd, int balance, LocalDate birthday, String mobile,
				Address address, Cart cart, String profile_url, String provider, Set<Role> roles) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.passwd = passwd;
		this.balance = balance;
		this.birthday = birthday;
		this.mobile = mobile;
		this.address = address;
		this.cart = cart;
		this.profile_url = profile_url;
		this.provider = provider;
		this.roles = roles;
	}

	public void setUser(String email, String username, String passwd,LocalDate birthday, String mobile){
		this.email = email;
		this.username = username;
		this.passwd = passwd;
		this.birthday = birthday;
		this.mobile = mobile;
	}

	public void setBalance(int money){
		this.balance = balance - money;
	}
}
