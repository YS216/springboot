package com.study.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name="BOARDAM")
public class Board {
	@Id
	@GeneratedValue
	private Long bno;
	private String title;
	private String content;
	
	@ManyToOne  // 다대일 관계
	@JoinColumn(name="writer")
	private Member member;	// Member객체의 @Id 필드의 값이 들어값
}
