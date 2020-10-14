package com.funweb.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.funweb.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;

}
