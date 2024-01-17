package com.study.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.domain.Member;
import com.study.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "menu";
	}
	
	@GetMapping("/insert")
	public String insert(@RequestParam("username") String username, Model model) {
		// 나에게 맞는 생성자를 만드는 용도로 사용
		// 가독성이 좋다
		Member member = Member.builder()
						.username(username)
						.createDate(LocalDate.now())
						.build();
		Member result = memberService.insert(member);
		model.addAttribute("member", result);
		
		return "insert";
	}
	
	@GetMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		Optional<Member> result = memberService.select(id);
		// result.get().getUsername();
		// result.get().getId();
		
		// 받을 때 Wrapping을 벗겨줘도 된다
		// Member member = memberService.select(id).get();
		
		// isPresent() : 데이터가 있는지 없는지 체크
		if(result.isPresent()) {
			model.addAttribute("member", result.get());  // Member형으로 넘겨줌
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		model.addAttribute("members", memberService.selectAll());
		return "selectAll";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		return "redirect:selectAll";
	}
	
	@GetMapping("/update")
	public String update(Member member, Model model) {
		model.addAttribute("member", memberService.update(member));
		return "update";
	}
}