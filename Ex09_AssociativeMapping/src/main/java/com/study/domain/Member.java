package com.study.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="MEMBERAM")
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
	private String id;
	private String name;
	private String password;
	
	// 생성되는 시간을 자동으로 넣어줌
	@CreatedDate
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	// 엔티티가 수정될 때 수정시간을 넣어줌
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;
	/*
 	@CreatedDate와 @LastModifiedDate를 사용할 때 반드시 
	  - Entity 에 @EntityListeners(AuditingEntityListener.class) 어노테이션 달기
	  - main()메소드가 있는 클래스에도 @EnableJpaAuditing 어노테이션 달기
	*/
}
