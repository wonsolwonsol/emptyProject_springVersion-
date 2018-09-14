package com.dto;

public class Goods {
	String goods_Code;
	String goods_Color;
	String goods_Name;
	String goods_Content;
	String goods_Price;
	String goods_Brand;
	String goods_Image1;
	String goods_Image2;
	String goods_Category;
	String goods_Date;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(String goods_Code, String goods_Color, String goods_Name, String goods_Content, String goods_Price,
			String goods_Brand, String goods_Image1, String goods_Image2, String goods_Category, String goods_Date) {
		super();
		this.goods_Code = goods_Code;
		this.goods_Color = goods_Color;
		this.goods_Name = goods_Name;
		this.goods_Content = goods_Content;
		this.goods_Price = goods_Price;
		this.goods_Brand = goods_Brand;
		this.goods_Image1 = goods_Image1;
		this.goods_Image2 = goods_Image2;
		this.goods_Category = goods_Category;
		this.goods_Date = goods_Date;
	}

	public String getGoods_Code() {
		return goods_Code;
	}

	public void setGoods_Code(String goods_Code) {
		this.goods_Code = goods_Code;
	}

	public String getGoods_Color() {
		return goods_Color;
	}

	public void setGoods_Color(String goods_Color) {
		this.goods_Color = goods_Color;
	}

	public String getGoods_Name() {
		return goods_Name;
	}

	public void setGoods_Name(String goods_Name) {
		this.goods_Name = goods_Name;
	}

	public String getGoods_Content() {
		return goods_Content;
	}

	public void setGoods_Content(String goods_Content) {
		this.goods_Content = goods_Content;
	}

	public String getGoods_Price() {
		return goods_Price;
	}

	public void setGoods_Price(String goods_Price) {
		this.goods_Price = goods_Price;
	}

	public String getGoods_Brand() {
		return goods_Brand;
	}

	public void setGoods_Brand(String goods_Brand) {
		this.goods_Brand = goods_Brand;
	}

	public String getGoods_Image1() {
		return goods_Image1;
	}

	public void setGoods_Image1(String goods_Image1) {
		this.goods_Image1 = goods_Image1;
	}

	public String getGoods_Image2() {
		return goods_Image2;
	}

	public void setGoods_Image2(String goods_Image2) {
		this.goods_Image2 = goods_Image2;
	}

	public String getGoods_Category() {
		return goods_Category;
	}

	public void setGoods_Category(String goods_Category) {
		this.goods_Category = goods_Category;
	}

	public String getGoods_Date() {
		return goods_Date;
	}

	public void setGoods_Date(String goods_Date) {
		this.goods_Date = goods_Date;
	}

	@Override
	public String toString() { 
		return "GoodsDTO [goods_Code=" + goods_Code + ", goods_Color=" + goods_Color + ", goods_Name=" + goods_Name
				+ ", goods_Content=" + goods_Content + ", goods_Price=" + goods_Price + ", goods_Brand=" + goods_Brand
				+ ", goods_Image1=" + goods_Image1 + ", goods_Image2=" + goods_Image2 + ", goods_Category="
				+ goods_Category + ", goods_Date=" + goods_Date + "]";
	}	
}

