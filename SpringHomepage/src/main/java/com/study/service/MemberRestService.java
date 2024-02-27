package com.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.Member;
import com.study.dto.UserDto;
import com.study.repository.MemberRepository;

@Service
public class MemberRestService {

	@Autowired
	MemberRepository memberRepository;
	
	public Member saveUserDto(UserDto userDto) {
		Member member = new Member();
		member.setId(userDto.getId());
		member.setPassword("1234");
		member.setName(userDto.getName());
		
		return memberRepository.save(member);
	}

	public UserDto getUserById(String id) {
		/*
		Member m = memberRepository.findById(id).get();
		UserDto userDto = new UserDto(); 
		userDto.setId(m.getId());
		userDto.setName(m.getName());
		*/
		return new UserDto(memberRepository.findById(id).get());
	}

	public List<Member> getUserAll() {
		return memberRepository.findAll();
	}

	public List<UserDto> getUserDtoAll() {
		// List<Member> mList = memberRepository.findAll();
		List<UserDto> uList = new ArrayList<>();
		for(Member m : memberRepository.findAll()) {
			uList.add(new UserDto(m));
		}
		return uList;
	}
}
