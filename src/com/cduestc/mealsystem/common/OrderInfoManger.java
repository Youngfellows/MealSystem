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
	 * ���涩�������ݿ�
	 * 
	 * @param orderInfo
	 *            Ҫ����Ķ���
	 * @return true������ɹ��� false������ʧ�ܡ�
	 */
	public boolean saveOrder(OrderInfo orderInfo) {
		return true;
	}

	/**
	 * ����¶�����δ������б�
	 * 
	 * @param orderInfo
	 *            δ������¶���
	 * @return
	 */
	public boolean addUnpaidOrder(OrderInfo orderInfo) {
		return unpaidOrderList.add(orderInfo);
	}

	public ArrayList<OrderInfo> getUnpaidOrderList() {
		return this.unpaidOrderList;
	}

	public boolean checkOutOrder(OrderInfo orderInfo) {
		// ���浽���ݿ�
		saveOrder(orderInfo);
		return unpaidOrderList.remove(orderInfo);
	}

	/**
	 * ���ݶ����Ų�ѯ����
	 * 
	 * @param orderId
	 * @return
	 */
	// ����ֻ�ܲ�δ�����
	public boolean quiryOrder(String orderId) {
		for (OrderInfo orderInfo : unpaidOrderList) {
			if (orderInfo.getId().equals(orderId))
				return true;
		}
		return false;
	}

}
