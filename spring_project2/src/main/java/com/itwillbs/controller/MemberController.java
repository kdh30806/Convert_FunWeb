package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;

	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {

		return "member/insertForm";
	}

	@RequestMapping(value = "member/insert", method = RequestMethod.POST)
	public String insertPost(MemberBean mb) {
		
		System.out.println(mb.getId());
		System.out.println(mb.getPass());
		System.out.println(mb.getName());
		
		memberService.insertMember(mb);
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {

		return "member/loginForm";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPorst(HttpSession session ,MemberBean mb, Model model) {

		MemberBean mb2 =memberService.userCheck(mb);
		
		if(mb2 != null) {
			System.out.println("아이비 및 비밀번호 일치");
			session.setAttribute("id", mb.getId());
			return "redirect:main";
		} else {
			System.out.println("비밀번호 불일치");
			model.addAttribute("msg","입력하신 내용 틀립니다.");
			return "member/msg";
		}	
	}
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {

		return "member/main";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();
		return "member/main";
	}
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {

		String id = (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		
		model.addAttribute("mb", mb);
		return "member/info";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		
		model.addAttribute("mb", mb);

		return "member/updateForm";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String updatePost(MemberBean mb, Model model) {
		
		memberService.updateMember(mb);
		
		return "member/main";
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete(MemberBean mb, Model model) {
		
		return "member/deleteForm";
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public String deletePorst(MemberBean mb, HttpSession session) {
		
		MemberBean mb2 = memberService.userCheck(mb);
		
		if(mb2 != null) {
			memberService.deleteMember(mb2);
			session.invalidate();
		} else {
			System.out.println("비밀번호 불일치");
		}
		
		return "member/main";
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(MemberBean mb, Model model) {
		
		List<MemberBean> memberList = memberService.getMemberList();
		model.addAttribute("memberList",memberList);
		return "member/list";
	}
}
