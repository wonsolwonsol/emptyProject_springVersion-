package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Login;
import com.dto.Member;
import com.dto.Order;

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

	public int memberUpdate(Member member) {
		System.out.println(member);
		int n = template.update("MemberMapper.memberUpdate", member);
		return n;
	}

	public int idCheck(String userid) {
		int n = template.selectOne("MemberMapper.idCheck",userid);
		return n;
	}

	public String idfind(Member member) {
		String userid = template.selectOne("MemberMapper.idFind", member);
		return userid;
	}

	public List<Order> orderList(String userid) {
		List<Order> list = template.selectList("OrderMapper.orderlist", userid);
		return list;
	}

}
