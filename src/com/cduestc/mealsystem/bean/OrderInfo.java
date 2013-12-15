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
	// �ж϶����Ƿ񱻴���
	private int isTake; // 0,δ���� 1����
	private String mOrderTime;
	private String tableNum;
	private int customerSum = 1; // Ĭ��һλ�˿�

	public OrderInfo() {
		this.orderFoodInfoList = new ArrayList<FoodInfo>();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss     ");
		Date curDate = new Date(System.currentTimeMillis());// ��ȡ��ǰʱ��
		this.mOrderTime = formatter.format(curDate);
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss     ");
		Date curDat = new Date(System.currentTimeMillis());// ��ȡ��ǰʱ��
		this.id = f.format(curDat);
	}

	// ע���ȡ˳��
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
	 * ��ʳ����ӵ�����
	 * 
	 * @param foodInfo
	 * @return true����ӳɹ��� false�����ʧ��
	 */
	public boolean addFood(FoodInfo foodInfo) {
		return orderFoodInfoList.add(foodInfo);
	}

	/**
	 * ɾ��ָ��ʳ��
	 * 
	 * @param foodInfo
	 * @return true��ɾ���ɹ��� false��ɾ��ʧ��
	 */
	public boolean removeFood(FoodInfo foodInfo) {
		return orderFoodInfoList.remove(foodInfo);
	}

	/**
	 * ��ȡ��ǰ����������ʳ���List
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

	// ʵ������̬�ڲ�����CREATORʵ�ֽӿ�OrderInfo.Creator
	public static final OrderInfo.Creator<OrderInfo> CREATOR = new Creator<OrderInfo>() {

		@Override
		public OrderInfo[] newArray(int size) {
			return new OrderInfo[size];
		}

		// ��Parcel�������л�ΪOrderInfo
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
