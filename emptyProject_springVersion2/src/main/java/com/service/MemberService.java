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
}
