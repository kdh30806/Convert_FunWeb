package com.shopping.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.service.memberService;

@Controller
public class memberController {
	
	@Inject
	private memberService memberService;
	
	@RequestMapping(value = "/member/join", method= RequestMethod.GET)
	public String join() {
		
		return "/member/join";
	}
}
