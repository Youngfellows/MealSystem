package com.cduestc.mealsystem.common;

import java.util.ArrayList;

import android.content.Context;

import com.cduestc.mealsystem.bean.OrderInfo;

public class OrderInfoManger {

	private static OrderInfoManger mInstance;
	private Context ctx;
	private ArrayList<OrderInfo> unpayOrderList;

	private OrderInfoManger(Context ctx) {
		this.ctx = ctx;
		this.unpayOrderList = new ArrayList<OrderInfo>();
	}

	public static OrderInfoManger getInstance(Context ctx) {
		if (mInstance == null) {
			mInstance = new OrderInfoManger(ctx);
		}
		return mInstance;
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

	public boolean addToUnpayOrderList(OrderInfo orderInfo) {
		return unpayOrderList.add(orderInfo);
	}

	public boolean removeFromUnpayOrderList(OrderInfo orderInfo) {
		return unpayOrderList.remove(orderInfo);
	}

}
