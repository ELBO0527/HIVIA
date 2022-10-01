package com.example.hibia.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@DynamicInsert null값 제외하고 생성
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id") // 양뱡향 무한참조
@Table(name = "user")
public class User implements UserDetails {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String passwd;

	@Column(columnDefinition = "integer default 0")
	private int balance;

	@Column
	private LocalDate birthday;

	@Column
	private String mobile;

	//주소,상세주소,우편번호,장바구니 추가(2022-07-19)
	@Column
	private String addr;

	@Column
	private String addr_detail;

	@Column
	private String zipcode;

	//한명의 유저는 하나의 장바구니
	@OneToOne(mappedBy = "user")
	private Cart cart;

	@Column
	private String profile_url;

	@Column
	private String provider;

	@ElementCollection(fetch = FetchType.EAGER)
	@Builder.Default
	private List<String> roles = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public String getUsername(){
		return this.username;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public String getPassword() {
		return this.passwd;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isEnabled() {
		return true;
	}

	public User setUser(String email, String username, String passwd,LocalDate birthday, String mobile, String addr
	 					, String addr_detail, String zipcode){
		this.email = email;
		this.username = username;
		this.passwd = passwd;
		this.birthday = birthday;
		this.mobile = mobile;
		this.addr = addr;
		this.addr_detail = addr_detail;
		this.zipcode = zipcode;
		return this;
	}

	public User setBalance(int money){
		this.balance = balance - money;
		return this;
	}
}
