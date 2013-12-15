package com.cduestc.mealsystem.common;

import java.util.ArrayList;

import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.MainFuncInfo;
import com.cduestc.mealsystem.bean.MainMenuInfo;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.bean.TableInfo;

public class DataFactory {

	/**
	 * ��ȡ�����Ŀ¼
	 * 
	 * @return
	 */
	public static ArrayList<MainMenuInfo> getMainMenuList() {
		ArrayList<MainMenuInfo> mainMenuList = new ArrayList<MainMenuInfo>();
		mainMenuList.add(new MainMenuInfo("0", "������ʳ"));
		mainMenuList.add(new MainMenuInfo("1", "����"));
		mainMenuList.add(new MainMenuInfo("2", "ˮ��"));
		mainMenuList.add(new MainMenuInfo("3", "������"));
		mainMenuList.add(new MainMenuInfo("4", "��ɫ����"));
		mainMenuList.add(new MainMenuInfo("5", "����"));
		mainMenuList.add(new MainMenuInfo("6", "��ͳС��"));
		return mainMenuList;
	}

	/**
	 * ������Ŀ¼id��ȡ��ϸ�˵�Ŀ¼
	 * 
	 * @param mainMenuId
	 * @return
	 */
	public static ArrayList<FoodInfo> getDetailMenu(String mainMenuId) {
		ArrayList<FoodInfo> foodInfoList = new ArrayList<FoodInfo>();
		switch (Integer.parseInt(mainMenuId)) {
		case 0:
			FoodInfo qtcs = new FoodInfo("0", "��������", 10.0f, 1, null);
			FoodInfo htcs = new FoodInfo("1", "��������", 10.0f, 1, null);
			foodInfoList.add(qtcs);
			foodInfoList.add(htcs);
			break;
		case 1:
			FoodInfo nrmx = new FoodInfo("2", "ţ������", 10.0f, 1, null);
			FoodInfo fcmx = new FoodInfo("3", "�ʳ�����", 8.0f, 1, null);
			FoodInfo zjmx = new FoodInfo("4", "�ӽ�����", 8.0f, 1, null);
			FoodInfo sxmx = new FoodInfo("5", "��������", 8.0f, 1, null);
			FoodInfo scrsmx = new FoodInfo("6", "�����˿����", 8.0f, 1, null);
			FoodInfo smx = new FoodInfo("28", "������", 6.0f, 1, null);
			foodInfoList.add(nrmx);
			foodInfoList.add(fcmx);
			foodInfoList.add(zjmx);
			foodInfoList.add(sxmx);
			foodInfoList.add(scrsmx);
			foodInfoList.add(smx);
			break;
		case 2:
			FoodInfo nrsf = new FoodInfo("7", "ţ��ˮ��", 10.0f, 1, null);
			FoodInfo fcsf = new FoodInfo("8", "�ʳ�ˮ��", 8.0f, 1, null);
			FoodInfo zjsf = new FoodInfo("9", "�ӽ�ˮ��", 8.0f, 1, null);
			FoodInfo sxsf = new FoodInfo("10", "����ˮ��", 8.0f, 1, null);
			FoodInfo scrssf = new FoodInfo("11", "�����˿ˮ��", 8.0f, 1, null);
			FoodInfo sssf = new FoodInfo("12", "��ˮ��", 6.0f, 1, null);
			foodInfoList.add(nrsf);
			foodInfoList.add(fcsf);
			foodInfoList.add(zjsf);
			foodInfoList.add(sxsf);
			foodInfoList.add(scrssf);
			foodInfoList.add(sssf);
			break;
		case 3:
			FoodInfo nrdxm = new FoodInfo("13", "ţ�⵶����", 10.0f, 1, null);
			FoodInfo fcdxm = new FoodInfo("14", "�ʳ�������", 10.0f, 1, null);
			FoodInfo zjdxm = new FoodInfo("15", "�ӽ�������", 10.0f, 1, null);
			FoodInfo gzdxm = new FoodInfo("16", "���ӵ�����", 10.0f, 1, null);
			foodInfoList.add(nrdxm);
			foodInfoList.add(fcdxm);
			foodInfoList.add(zjdxm);
			foodInfoList.add(gzdxm);
			break;
		case 4:
			FoodInfo wmhsf = new FoodInfo("17", "���軨����", 10.0f, 1, null);
			FoodInfo kxhsf = new FoodInfo("18", "���Ĺ�����", 10.0f, 1, null);
			FoodInfo hwdhsf = new FoodInfo("19", "���㶹����", 10.0f, 1, null);
			foodInfoList.add(wmhsf);
			foodInfoList.add(kxhsf);
			foodInfoList.add(hwdhsf);
		case 5:
			FoodInfo tdscf = new FoodInfo("20", "����˿����", 10.0f, 1, null);
			FoodInfo dcf = new FoodInfo("21", "������", 10.0f, 1, null);
			FoodInfo qjcf = new FoodInfo("22", "�ཷ����", 10.0f, 1, null);
			FoodInfo hjscf = new FoodInfo("23", "�콷����", 10.0f, 1, null);
			foodInfoList.add(tdscf);
			foodInfoList.add(dcf);
			foodInfoList.add(qjcf);
			foodInfoList.add(hjscf);
		case 6:
			FoodInfo lg = new FoodInfo("24", "����", 10.0f, 1, null);
			FoodInfo lf = new FoodInfo("25", "����", 10.0f, 1, null);
			FoodInfo bbz = new FoodInfo("26", "�˱���", 10.0f, 1, null);
			FoodInfo yet = new FoodInfo("27", "������", 10.0f, 1, null);
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
	 * ��ȡ����List
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
