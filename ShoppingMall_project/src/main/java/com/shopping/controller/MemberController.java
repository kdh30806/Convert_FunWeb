package com.shopping.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.domain.MemberBean;
import com.shopping.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/join", method= RequestMethod.GET)
	public String join() {
		
		return "/member/join";
	}
	
	@RequestMapping(value = "/member/join", method= RequestMethod.POST)
	public String joinPost(MemberBean mb) {	
		memberService.insertMember(mb);
		return "/main";
	}
	
	@RequestMapping(value = "/member/login", method= RequestMethod.GET)
	public String login() {
		
		return "/member/login";
	}
}
