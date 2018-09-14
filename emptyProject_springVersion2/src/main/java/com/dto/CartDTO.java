package com.dto;

public class CartDTO {
	private int num;
	private String userid;
	private String goods_code;
	private String goods_name;
	private int goods_price;
	private String goods_color;
	private int goods_amount;
	private String goods_image;
	private String goods_brand;
	
	public CartDTO() {
		super();
	}

	public CartDTO(int num, String userid, String goods_code, String goods_name, int goods_price, String goods_color,
			int goods_amount, String goods_image, String goods_brand) {
		super();
		this.num = num;
		this.userid = userid;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_color = goods_color;
		this.goods_amount = goods_amount;
		this.goods_image = goods_image;
		this.goods_brand = goods_brand;
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

	public String getGoods_code() {
		return goods_code;
	}

	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_color() {
		return goods_color;
	}

	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}

	public int getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(int goods_amount) {
		this.goods_amount = goods_amount;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public String getGoods_brand() {
		return goods_brand;
	}

	public void setGoods_brand(String goods_brand) {
		this.goods_brand = goods_brand;
	}

	@Override
	public String toString() {
		return "CartDTO [num=" + num + ", userid=" + userid + ", goods_code=" + goods_code + ", goods_name="
				+ goods_name + ", goods_price=" + goods_price + ", goods_color=" + goods_color + ", goods_amount="
				+ goods_amount + ", goods_image=" + goods_image + ", goods_brand=" + goods_brand + "]";
	}	
}
