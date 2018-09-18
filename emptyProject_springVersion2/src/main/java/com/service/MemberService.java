package com.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dao.MemberDAO;
import com.dto.Login;
import com.dto.Member;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;

	public Member login(Login login) {
		Member mem = dao.login(login);
		return mem;
	}

	public int memberAdd(Member member) {
		int n = dao.memberAdd(member);
		return n;
	}

	public int memberUpdate(Member member) {
		int n = dao.memberUpdate(member);
		return n;
	}

	public int idCheck(String userid) {
		int n = dao.idCheck(userid);
		return n;
	}

	public String idfind(Member member) {
		String userid = dao.idfind(member);
		return userid;
	}
}
