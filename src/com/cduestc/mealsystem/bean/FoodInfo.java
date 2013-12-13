package com.cduestc.mealsystem.bean;

import android.graphics.drawable.Drawable;

public class FoodInfo {

	String id;
	String name;
	Float price;
	// 数量默认为1
	int num = 1;
	Drawable pic;

	public FoodInfo() {

	}

	public FoodInfo(String id, String name, Float price, int num, Drawable pic) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
		this.pic = pic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Drawable getPic() {
		return pic;
	}

	public void setPic(Drawable pic) {
		this.pic = pic;
	}

}
