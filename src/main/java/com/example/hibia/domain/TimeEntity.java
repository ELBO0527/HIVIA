package com.example.hibia.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass //테이블 매핑 안하고 자식 테이블에 매핑정보 상속
@EntityListeners(AuditingEntityListener.class) //Auditing을 알림
public class TimeEntity {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate; 

}
