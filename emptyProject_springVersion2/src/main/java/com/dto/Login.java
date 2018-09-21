package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Login")
public class Login {
	private String userid;
	private String passwd;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "Login [userid=" + userid + ", passwd=" + passwd + "]";
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String userid, String passwd) {
		super();
		this.userid = userid;
		this.passwd = passwd;
	}

	
}
