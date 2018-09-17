package com.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Login;
import com.dto.Member;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate template;

	public Member login(Login login) {
		Member mem = template.selectOne("MemberMapper.login", login);
		return mem;
	}

	public int memberAdd(Member member) {
		int n = template.insert("MemberMapper.memberAdd", member);
		return n;
	}

}
