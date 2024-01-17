package com.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.Member;
import com.study.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	public Member insert(Member member) {
		// save() : insert해주는 메소드
		Member rMember = memberRepository.save(member);
		return rMember;
	}

	/*
	 * Optional<T> : NullpointerException을 방지하기 위해 사용
	 *   			 기존의 반환 값 타입 T에 Optional<T>를 Wrapping하여,
	 *   			 null 대신 Optional안에 빈 타입 객체를 돌려준다
	 *     ex) Member member = memberRepository.findById("userid"); -> 그 값이 없을 때
	 *         member.getUsername(); => 호출시 NullpointerException 발생 
	 */
	public Optional<Member> select(Long id) {
		// findById() : Entity에서 @Id가 붙은 필드를 의미
		Optional<Member> member = memberRepository.findById(id);
		return member;	
	}

	public List<Member> selectAll() {
		return memberRepository.findAll();
	}

	public void delete(Long id) {
		memberRepository.deleteById(id);	
	}

	public Member update(Member member) {
		// insert메서드와 같은 방법으로 한다
		// @Id필드의 값이 DB에 들어있으면 업데이트, 없으면 insert해줌
		return memberRepository.save(member);
	}
}
