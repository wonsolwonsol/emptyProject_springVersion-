package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Cart")
public class Cart {
	private int num;
	private String userid;
	private String goods_Code;
	private String goods_Name;
	private int goods_Price;
	private String goods_Color;
	private int goods_Amount;
	private String goods_Image;
	private String goods_Brand;
	
	public Cart() {
		super();
	}

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

	@Override
	public String toString() {
		return "Cart [num=" + num + ", userid=" + userid + ", goods_Code=" + goods_Code + ", goods_Name=" + goods_Name
				+ ", goods_Price=" + goods_Price + ", goods_Color=" + goods_Color + ", goods_Amount=" + goods_Amount
				+ ", goods_Image=" + goods_Image + ", goods_Brand=" + goods_Brand + "]";
	}

	public Cart(int num, String userid, String goods_Code, String goods_Name, int goods_Price, String goods_Color,
			int goods_Amount, String goods_Image, String goods_Brand) {
		super();
		this.num = num;
		this.userid = userid;
		this.goods_Code = goods_Code;
		this.goods_Name = goods_Name;
		this.goods_Price = goods_Price;
		this.goods_Color = goods_Color;
		this.goods_Amount = goods_Amount;
		this.goods_Image = goods_Image;
		this.goods_Brand = goods_Brand;
	}

	
	
}