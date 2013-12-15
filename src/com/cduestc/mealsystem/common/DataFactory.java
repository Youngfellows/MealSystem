package com.cduestc.mealsystem.common;

import java.util.ArrayList;

import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.MainFuncInfo;
import com.cduestc.mealsystem.bean.MainMenuInfo;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.bean.TableInfo;

public class DataFactory {

	/**
	 * 获取点餐主目录
	 * 
	 * @return
	 */
	public static ArrayList<MainMenuInfo> getMainMenuList() {
		ArrayList<MainMenuInfo> mainMenuList = new ArrayList<MainMenuInfo>();
		mainMenuList.add(new MainMenuInfo("0", "经典热食"));
		mainMenuList.add(new MainMenuInfo("1", "米线"));
		mainMenuList.add(new MainMenuInfo("2", "水粉"));
		mainMenuList.add(new MainMenuInfo("3", "刀削面"));
		mainMenuList.add(new MainMenuInfo("4", "特色凉粉"));
		mainMenuList.add(new MainMenuInfo("5", "炒饭"));
		mainMenuList.add(new MainMenuInfo("6", "传统小吃"));
		return mainMenuList;
	}

	/**
	 * 根据主目录id获取详细菜单目录
	 * 
	 * @param mainMenuId
	 * @return
	 */
	public static ArrayList<FoodInfo> getDetailMenu(String mainMenuId) {
		ArrayList<FoodInfo> foodInfoList = new ArrayList<FoodInfo>();
		switch (Integer.parseInt(mainMenuId)) {
		case 0:
			FoodInfo qtcs = new FoodInfo("0", "清汤抄手", 10.0f, 1, null);
			FoodInfo htcs = new FoodInfo("1", "红汤抄手", 10.0f, 1, null);
			foodInfoList.add(qtcs);
			foodInfoList.add(htcs);
			break;
		case 1:
			FoodInfo nrmx = new FoodInfo("2", "牛肉米线", 10.0f, 1, null);
			FoodInfo fcmx = new FoodInfo("3", "肥肠米线", 8.0f, 1, null);
			FoodInfo zjmx = new FoodInfo("4", "杂酱米线", 8.0f, 1, null);
			FoodInfo sxmx = new FoodInfo("5", "三鲜米线", 8.0f, 1, null);
			FoodInfo scrsmx = new FoodInfo("6", "酸菜肉丝米线", 8.0f, 1, null);
			FoodInfo smx = new FoodInfo("28", "素米线", 6.0f, 1, null);
			foodInfoList.add(nrmx);
			foodInfoList.add(fcmx);
			foodInfoList.add(zjmx);
			foodInfoList.add(sxmx);
			foodInfoList.add(scrsmx);
			foodInfoList.add(smx);
			break;
		case 2:
			FoodInfo nrsf = new FoodInfo("7", "牛肉水粉", 10.0f, 1, null);
			FoodInfo fcsf = new FoodInfo("8", "肥肠水粉", 8.0f, 1, null);
			FoodInfo zjsf = new FoodInfo("9", "杂酱水粉", 8.0f, 1, null);
			FoodInfo sxsf = new FoodInfo("10", "三鲜水粉", 8.0f, 1, null);
			FoodInfo scrssf = new FoodInfo("11", "酸菜肉丝水粉", 8.0f, 1, null);
			FoodInfo sssf = new FoodInfo("12", "素水粉", 6.0f, 1, null);
			foodInfoList.add(nrsf);
			foodInfoList.add(fcsf);
			foodInfoList.add(zjsf);
			foodInfoList.add(sxsf);
			foodInfoList.add(scrssf);
			foodInfoList.add(sssf);
			break;
		case 3:
			FoodInfo nrdxm = new FoodInfo("13", "牛肉刀削面", 10.0f, 1, null);
			FoodInfo fcdxm = new FoodInfo("14", "肥肠刀削面", 10.0f, 1, null);
			FoodInfo zjdxm = new FoodInfo("15", "杂酱刀削面", 10.0f, 1, null);
			FoodInfo gzdxm = new FoodInfo("16", "干杂刀削面", 10.0f, 1, null);
			foodInfoList.add(nrdxm);
			foodInfoList.add(fcdxm);
			foodInfoList.add(zjdxm);
			foodInfoList.add(gzdxm);
			break;
		case 4:
			FoodInfo wmhsf = new FoodInfo("17", "王妈花生粉", 10.0f, 1, null);
			FoodInfo kxhsf = new FoodInfo("18", "开心刮生粉", 10.0f, 1, null);
			FoodInfo hwdhsf = new FoodInfo("19", "黄豌豆凉粉", 10.0f, 1, null);
			foodInfoList.add(wmhsf);
			foodInfoList.add(kxhsf);
			foodInfoList.add(hwdhsf);
		case 5:
			FoodInfo tdscf = new FoodInfo("20", "土豆丝炒饭", 10.0f, 1, null);
			FoodInfo dcf = new FoodInfo("21", "蛋炒饭", 10.0f, 1, null);
			FoodInfo qjcf = new FoodInfo("22", "青椒炒饭", 10.0f, 1, null);
			FoodInfo hjscf = new FoodInfo("23", "红椒炒饭", 10.0f, 1, null);
			foodInfoList.add(tdscf);
			foodInfoList.add(dcf);
			foodInfoList.add(qjcf);
			foodInfoList.add(hjscf);
		case 6:
			FoodInfo lg = new FoodInfo("24", "凉糕", 10.0f, 1, null);
			FoodInfo lf = new FoodInfo("25", "凉粉", 10.0f, 1, null);
			FoodInfo bbz = new FoodInfo("26", "八宝粥", 10.0f, 1, null);
			FoodInfo yet = new FoodInfo("27", "银耳汤", 10.0f, 1, null);
			foodInfoList.add(lg);
			foodInfoList.add(lf);
			foodInfoList.add(bbz);
			foodInfoList.add(yet);
			break;
		}
		return foodInfoList;
	}

	private static ArrayList<TableInfo> tableInfoList;

	/**
	 * 获取餐桌List
	 * 
	 * @return
	 */
	public static ArrayList<TableInfo> getTableInfoList() {
		if (tableInfoList == null) {
			tableInfoList = new ArrayList<TableInfo>();
			for (int i = 0; i < 10; i++) {
				tableInfoList.add(new TableInfo(0, i));
			}
		}
		return tableInfoList;
	}

}
