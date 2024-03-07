package com.beta.replyservice.controller;

import com.beta.replyservice.model.ReplyMessage;
import com.beta.replyservice.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/reply")
public class ReplyControllerV2 {

	private final ReplyService replyService;

	@Autowired
	public ReplyControllerV2(@Qualifier("V2") ReplyService replyService) {
		this.replyService = replyService;
	}

	@GetMapping("/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(replyService.generateReply(message));
	}
}