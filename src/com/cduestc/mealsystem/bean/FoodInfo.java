package com.cduestc.mealsystem.bean;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

public class FoodInfo  {

	String id;
	String name;
	Float price;
	// ����Ĭ��Ϊ1
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

	public void addNum() {
		this.num++;
	}

	public void subNum() {
		if (this.num > 1) {
			this.num--;
		}
	}

	/**
	 * ��дequals������ֻ�е�id��ͬ��ʱ�򣬲ŷ���true
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof FoodInfo) {
			if (((FoodInfo) o).getId().equals(this.id)) {
				return true;
			}
		} else {
			return false;
		}
		return super.equals(o);
	}

	/**
	 * ��һ��FoodInfo�����ݸ��Ƶ��µ�FoodInfo
	 * 
	 * @param foodInfo
	 *            �����Ƶ�FoodInfo
	 * @param newFoodInfo
	 *            ���Ƶ�FoodInfo
	 */
	public static void copyFoodInfo(FoodInfo foodInfo, FoodInfo newFoodInfo) {
		newFoodInfo.setId(foodInfo.getId());
		newFoodInfo.setName(foodInfo.getName());
		newFoodInfo.setNum(foodInfo.getNum());
		newFoodInfo.setPic(foodInfo.getPic());
		newFoodInfo.setPrice(foodInfo.getPrice());
	}

}
