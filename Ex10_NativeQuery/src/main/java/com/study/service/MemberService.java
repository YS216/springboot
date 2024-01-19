package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.domain.Member;
import com.study.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	public List<Member> selectMembers1(String name) {
		return memberRepository.findMembers(name);
	}

	public List<Member> selectMembers2(String name, Sort sort) {
		return memberRepository.findMembers(name, sort);
	}

	public Page<Member> selectMembers3(String name, Pageable pageable) {
		return memberRepository.findMembers(name, pageable);
	}

	public List<Member> selectMembers4(String name) {
		return memberRepository.findMembersNative(name);
	}
}



