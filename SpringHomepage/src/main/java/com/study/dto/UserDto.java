package com.study.dto;

import com.study.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @AllArgsConstructor // 모든 피라미터가 있는 생성자
@NoArgsConstructor // 빈 생성자
public class UserDto {
	private String id;
	private String name;
	
	/*public UserDto(String id, String name) {
		this.id = id;
		this.name = name;
	}*/
	
	public UserDto(Member m) {
		id = m.getId();
		name = m.getName();
	}

}
