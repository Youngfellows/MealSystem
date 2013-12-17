package com.cduestc.mealsystem.bean;

public class TableInfo {

	private int flag; // 0表示空缺，1表示正在就餐
	private int num;
	
	public static final int VACANCY = 0;
	public static final int BUSY = 1;

	public TableInfo() {

	}

	public TableInfo(int flag, int num) {
		this.flag = flag;
		this.num = num;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
