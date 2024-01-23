package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.domain.Reply;
import com.study.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	ReplyService replyService;
	
	@ResponseBody
	@PostMapping("/rinsert.bo")
	public Reply replyForm(Reply reply) {
		return replyService.insert(reply);
	}
	
}
