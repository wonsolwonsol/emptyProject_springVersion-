package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Order")
public class Order {
	private int num;
	private String userid;
	private String username;
	private String goods_Code;
	private String goods_Name;
	private int goods_Price;
	private String goods_Color;
	private int goods_Amount;
	private String goods_Image;
	private String goods_Brand;
	private String post;
	private String addr1;
	private String addr2;
	private String phone;
	private String payMethod;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGoods_Code() {
		return goods_Code;
	}
	public void setGoods_Code(String goods_Code) {
		this.goods_Code = goods_Code;
	}
	public String getGoods_Name() {
		return goods_Name;
	}
	public void setGoods_Name(String goods_Name) {
		this.goods_Name = goods_Name;
	}
	public int getGoods_Price() {
		return goods_Price;
	}
	public void setGoods_Price(int goods_Price) {
		this.goods_Price = goods_Price;
	}
	public String getGoods_Color() {
		return goods_Color;
	}
	public void setGoods_Color(String goods_Color) {
		this.goods_Color = goods_Color;
	}
	public int getGoods_Amount() {
		return goods_Amount;
	}
	public void setGoods_Amount(int goods_Amount) {
		this.goods_Amount = goods_Amount;
	}
	public String getGoods_Image() {
		return goods_Image;
	}
	public void setGoods_Image(String goods_Image) {
		this.goods_Image = goods_Image;
	}
	public String getGoods_Brand() {
		return goods_Brand;
	}
	public void setGoods_Brand(String goods_Brand) {
		this.goods_Brand = goods_Brand;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	@Override
	public String toString() {
		return "Order [num=" + num + ", userid=" + userid + ", username=" + username + ", goods_Code=" + goods_Code
				+ ", goods_Name=" + goods_Name + ", goods_Price=" + goods_Price + ", goods_Color=" + goods_Color
				+ ", goods_Amount=" + goods_Amount + ", goods_Image=" + goods_Image + ", goods_Brand=" + goods_Brand
				+ ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone=" + phone + ", payMethod="
				+ payMethod + "]";
	}
	public Order(int num, String userid, String username, String goods_Code, String goods_Name, int goods_Price,
			String goods_Color, int goods_Amount, String goods_Image, String goods_Brand, String post, String addr1,
			String addr2, String phone, String payMethod) {
		super();
		this.num = num;
		this.userid = userid;
		this.username = username;
		this.goods_Code = goods_Code;
		this.goods_Name = goods_Name;
		this.goods_Price = goods_Price;
		this.goods_Color = goods_Color;
		this.goods_Amount = goods_Amount;
		this.goods_Image = goods_Image;
		this.goods_Brand = goods_Brand;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.payMethod = payMethod;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
