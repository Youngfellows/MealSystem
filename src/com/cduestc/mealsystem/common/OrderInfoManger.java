package com.cduestc.mealsystem.common;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.OrderInfo;

public class OrderInfoManger {

	private static OrderInfoManger mInstance;
	private Context ctx;
	private ArrayList<OrderInfo> unpaidOrderList;
	private OrderInfo curOrder;

	private OrderInfoManger(Context ctx) {
		this.ctx = ctx;
		this.unpaidOrderList = new ArrayList<OrderInfo>();
	}

	public static OrderInfoManger getInstance(Context ctx) {
		if (mInstance == null) {
			mInstance = new OrderInfoManger(ctx);
		}
		return mInstance;
	}

	public OrderInfo getCurOrder() {
		return curOrder;
	}

	public void setCurOrder(OrderInfo curOrderInfo) {
		this.curOrder = curOrderInfo;
	}

	/**
	 * 保存订单到数据库
	 * 
	 * @param orderInfo
	 *            要保存的订单
	 * @return true，保存成功。 false，保存失败。
	 */
	public boolean saveOrder(OrderInfo orderInfo) {
		return true;
	}

	/**
	 * 添加新订单到未付款订单列表
	 * 
	 * @param orderInfo
	 *            未付款的新订单
	 * @return
	 */
	public boolean addUnpaidOrder(OrderInfo orderInfo) {
		return unpaidOrderList.add(orderInfo);
	}

	public ArrayList<OrderInfo> getUnpaidOrderList() {
		return this.unpaidOrderList;
	}

	public boolean checkOutOrder(OrderInfo orderInfo) {
		// 保存到数据库
		saveOrder(orderInfo);
		return unpaidOrderList.remove(orderInfo);
	}

	/**
	 * 根据订单号查询订单
	 * 
	 * @param orderId
	 * @return
	 */
	// 现在只能查未付款订单
	public boolean quiryOrder(String orderId) {
		for (OrderInfo orderInfo : unpaidOrderList) {
			if (orderInfo.getId().equals(orderId))
				return true;
		}
		return false;
	}

}
