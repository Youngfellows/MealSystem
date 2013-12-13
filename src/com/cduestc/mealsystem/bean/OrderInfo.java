package com.cduestc.mealsystem.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.util.Log;

public class OrderInfo {

	private ArrayList<FoodInfo> orderList;
	// 判断订单是否被处理
	private boolean isTake;
	private String orderTime;

	public boolean isTake() {
		return isTake;
	}

	public void setTake(boolean isTake) {
		this.isTake = isTake;
	}

	public OrderInfo() {
		this.orderList = new ArrayList<FoodInfo>();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss     ");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		this.orderTime = formatter.format(curDate);
	}

	/**
	 * 将食物添加到订单
	 * 
	 * @param foodInfo
	 * @return true，添加成功； false，添加失败
	 */
	public boolean addFood(FoodInfo foodInfo) {
		return orderList.add(foodInfo);
	}

	/**
	 * 删除指定食物
	 * 
	 * @param foodInfo
	 * @return true，删除成功； false，删除失败
	 */
	public boolean removeFood(FoodInfo foodInfo) {
		return orderList.remove(foodInfo);
	}

	/**
	 * 获取当前订单内所有食物的List
	 * 
	 * @return
	 */
	public ArrayList<FoodInfo> getOrderList() {
		return this.orderList;
	}

}
