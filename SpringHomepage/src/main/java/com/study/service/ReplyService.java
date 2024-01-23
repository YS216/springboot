package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.Reply;
import com.study.repository.ReplyRepository;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository replyRepository;

	public List<Reply> findAllByRefBno(Long bno) {
		
		return replyRepository.findAllByRefBno(bno);
	}

	public Reply insert(Reply reply) {
		
		return replyRepository.save(reply);
	}

	
	

}
