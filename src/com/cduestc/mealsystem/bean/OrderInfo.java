package com.cduestc.mealsystem.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class OrderInfo implements Parcelable {

	private ArrayList<FoodInfo> orderFoodInfoList;
	private String id;
	// 判断订单是否被处理
	private int isTake; // 0,未处理 1处理
	private String mOrderTime;
	private String tableNum;
	private int customerSum = 1; // 默认一位顾客

	public OrderInfo() {
		this.orderFoodInfoList = new ArrayList<FoodInfo>();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss     ");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		this.mOrderTime = formatter.format(curDate);
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss     ");
		Date curDat = new Date(System.currentTimeMillis());// 获取当前时间
		this.id = f.format(curDat);
	}

	// 注意读取顺序
	public OrderInfo(Parcel source) {
		this.isTake = source.readInt();
		this.tableNum = source.readString();
		this.customerSum = source.readInt();
		this.mOrderTime = source.readString();
	}

	public int getIsTake() {
		return isTake;
	}

	public void setIsTake(int isTake) {
		this.isTake = isTake;
	}

	public String getTableNum() {
		return tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public int getCustomerSum() {
		return customerSum;
	}

	public void setCustomerSum(int customerSum) {
		this.customerSum = customerSum;
	}

	public String getOrderTime() {
		return mOrderTime;
	}

	public String getId() {
		return id;
	}

	/**
	 * 将食物添加到订单
	 * 
	 * @param foodInfo
	 * @return true，添加成功； false，添加失败
	 */
	public boolean addFood(FoodInfo foodInfo) {
		return orderFoodInfoList.add(foodInfo);
	}

	/**
	 * 删除指定食物
	 * 
	 * @param foodInfo
	 * @return true，删除成功； false，删除失败
	 */
	public boolean removeFood(FoodInfo foodInfo) {
		return orderFoodInfoList.remove(foodInfo);
	}

	/**
	 * 获取当前订单内所有食物的List
	 * 
	 * @return
	 */
	public ArrayList<FoodInfo> getOrderFoodInfoList() {
		return this.orderFoodInfoList;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(this.isTake);
		dest.writeString(this.tableNum);
		dest.writeInt(this.customerSum);
		dest.writeString(this.mOrderTime);
	}

	// 实例化静态内部对象CREATOR实现接口OrderInfo.Creator
	public static final OrderInfo.Creator<OrderInfo> CREATOR = new Creator<OrderInfo>() {

		@Override
		public OrderInfo[] newArray(int size) {
			return new OrderInfo[size];
		}

		// 将Parcel对象反序列化为OrderInfo
		@Override
		public OrderInfo createFromParcel(Parcel source) {
			return new OrderInfo(source);
		}
	};

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof OrderInfo) {
			if (((OrderInfo) o).getId().equals(this.id)) {
				return true;
			}
		} else {
			return false;
		}
		return super.equals(o);
	}

}
