package com.funweb.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.funweb.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String join(HttpServletRequest request, Model model) {
		
		
		return "/member/join";
	}
	
	@RequestMapping(value = "/member/juso", method = RequestMethod.GET)
	public String juso(HttpServletRequest request, Model model) {
		
		
		return "/member/address/jusoPopup";
	}

}
