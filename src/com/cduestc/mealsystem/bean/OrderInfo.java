package com.cduestc.mealsystem.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.util.Log;

public class OrderInfo {

	private ArrayList<FoodInfo> orderList;
	// �ж϶����Ƿ񱻴���
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
		Date curDate = new Date(System.currentTimeMillis());// ��ȡ��ǰʱ��
		this.orderTime = formatter.format(curDate);
	}

	/**
	 * ��ʳ����ӵ�����
	 * 
	 * @param foodInfo
	 * @return true����ӳɹ��� false�����ʧ��
	 */
	public boolean addFood(FoodInfo foodInfo) {
		return orderList.add(foodInfo);
	}

	/**
	 * ɾ��ָ��ʳ��
	 * 
	 * @param foodInfo
	 * @return true��ɾ���ɹ��� false��ɾ��ʧ��
	 */
	public boolean removeFood(FoodInfo foodInfo) {
		return orderList.remove(foodInfo);
	}

	/**
	 * ��ȡ��ǰ����������ʳ���List
	 * 
	 * @return
	 */
	public ArrayList<FoodInfo> getOrderList() {
		return this.orderList;
	}

}
