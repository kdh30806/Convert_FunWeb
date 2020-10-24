package com.funweb.controller;

import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.funweb.domain.MemberBean;
import com.funweb.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String join() {
		
		
		return "/member/join";
	}
	
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String joinPost(MemberBean mb) {
		

		memberService.insertMember(mb);
		
		return "redirect:../main";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		
		
		return "/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPost(MemberBean mb, Model model, HttpSession session) {
		
		MemberBean mb2 = memberService.loginMember(mb);
		
		if(mb2 == null) {
			System.out.println("비밀번호가 틀립니다.");
			model.addAttribute("msg", "비밀번호가 불일치합니다");
			return "member/msg";
		} else {
			session.setAttribute("id", mb2.getId());
			return "redirect:../main";
		}
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {		
		session.invalidate();
		return "redirect:../main";
	}
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {		
		
		String id = (String) session.getAttribute("id");		
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		return "member/info";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {		
		
		String id = (String) session.getAttribute("id");		
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		return "member/update";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String updatePost(MemberBean mb, Model model) {		
			
		MemberBean checkPass = memberService.checkPass(mb);
		
		if(checkPass != null) {
			memberService.updateMember(mb);
		} else {
			model.addAttribute("msg", "비밀번호가 일치 하지 않습니다");
			return "member/msg";
		}
		
		return "redirect:../main";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
