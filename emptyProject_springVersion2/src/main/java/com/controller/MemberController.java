package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.Login;
import com.dto.Member;
import com.dto.Order;
import com.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;

	@RequestMapping("/login")
	public String login(Login login, Model model, HttpSession session) {
  /*public String login(@Valid @ModelAttribute("login") Login login, BindingResult error, Model model, HttpSession session) {*/
		System.out.println("login "+login);
		Member mem = service.login(login);
		if(mem == null) {
			model.addAttribute("mesg","아이디 또는 비밀번호를 재학인 해주세요.");
			return "loginForm";
		}else {
			session.setAttribute("member", mem);
			System.out.println("세션에 login 저장 "+mem);
		}
		return "home";
	}
	@RequestMapping(value="/memberAdd", method=RequestMethod.POST)
	public String memberAdd(Member member, RedirectAttributes red) {
		System.out.println("회원가입 성공: "+member);
		
		int n = service.memberAdd(member);
		red.addFlashAttribute("success","회원가입에 성공했습니다.");
		
		return "redirect:/";
	}
	@RequestMapping("/loginCheck/logout")
	public String logout(HttpSession session ) {							
		session.invalidate();
		
		return "redirect:../";
	}
	@RequestMapping("/loginCheck/mypage")
	public String mypage(HttpSession session) {
		Member mem = (Member) session.getAttribute("member");
		List<Order> list = service.orderList(mem.getUserid());
		session.setAttribute("orderlist", list);
		return "redirect:../myPage";
	}
	
	@RequestMapping("/loginCheck/memberUpdate")
	public String memberUpdate(Member member, HttpSession session, RedirectAttributes red) {
		Member mem = (Member) session.getAttribute("member");
		member.setUsername(mem.getUsername());
		service.memberUpdate(member);
		System.out.println("       ????????            "+member);
		red.addFlashAttribute("mesg", "수정했습니다.");
		return "redirect:../";
	}
	@RequestMapping(value="/idCheck", produces="application/text; charset=UTF-8")
	public @ResponseBody String idCheck(@RequestParam String userid) {
		String mesg = "아이디 사용가능";
		int n = service.idCheck(userid);
		if(n == 1) {
			mesg = "아이디 중복";
		}
		return mesg;		
	}
	
	@RequestMapping(value="/idfind", method=RequestMethod.POST)
	public String idfind(Member member) {
		System.out.println("           member            "+member);
		String userid = service.idfind(member);
		System.out.println("userid "+userid);
		
		return "idFind";		
	}
	
}
