package com.study.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.Member;
import com.study.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;

	public boolean idCheck(String id) {
		return memberRepository.existsById(id);
	}

	public Member insert(Member member) {
		return memberRepository.save(member);		
	}

	public Member login(Member member) {
		Optional<Member> loginUser = memberRepository.findById(member.getId());
		if(loginUser.isPresent())
			return loginUser.get();
		else
			return null;
	}

}
