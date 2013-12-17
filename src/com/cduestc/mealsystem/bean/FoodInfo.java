package com.cduestc.mealsystem.bean;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class FoodInfo implements Parcelable {

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

	// 注意读取顺序
	public FoodInfo(Parcel source) {
		this.id = source.readString();
		this.name = source.readString();
		this.price = source.readFloat();
		this.num = source.readInt();
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
	 * 重写equals方法，只有当id相同的时候，才返回true
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
	 * 将一个FoodInfo的内容复制到新的FoodInfo
	 * 
	 * @param foodInfo
	 *            被复制的FoodInfo
	 * @param newFoodInfo
	 *            复制的FoodInfo
	 */
	public static void copyFoodInfo(FoodInfo foodInfo, FoodInfo newFoodInfo) {
		newFoodInfo.setId(foodInfo.getId());
		newFoodInfo.setName(foodInfo.getName());
		newFoodInfo.setNum(foodInfo.getNum());
		newFoodInfo.setPic(foodInfo.getPic());
		newFoodInfo.setPrice(foodInfo.getPrice());
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(this.id);
		dest.writeString(this.name);
		dest.writeFloat(this.price);
		dest.writeInt(this.num);
	}

	// 实例化静态内部对象CREATOR实现接口FoodInfo.Creator
	public static final FoodInfo.Creator<FoodInfo> CREATOR = new Creator<FoodInfo>() {

		@Override
		public FoodInfo[] newArray(int size) {
			return new FoodInfo[size];
		}

		// 将Parcel对象反序列化为OrderInfo
		@Override
		public FoodInfo createFromParcel(Parcel source) {
			return new FoodInfo(source);
		}
	};

}
