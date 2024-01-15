package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

		@RequestMapping("/")
		public @ResponseBody String root() {
			return "Security Welcome";
		}
		
		@RequestMapping("/guest/welcome")
		public String welcome3() {
			return "guest/welcome3";
		}
		
		@RequestMapping("/member/welcome")
		public String welcome2() {
			return "member/welcome2";
		}
		
		@RequestMapping("/admin/welcome")
		public String welcome1() {
			return "admin/welcome1";
		}
		
		// security에서는 GetMapping으로 함
		@GetMapping("/loginForm") 
		public String loginForm() {
			return "security/loginForm";
		}

		
}






