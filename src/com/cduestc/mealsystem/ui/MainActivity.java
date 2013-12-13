package com.cduestc.mealsystem.ui;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.adapter.MainFuncAdapter;
import com.cduestc.mealsystem.bean.MainFuncInfo;
import com.cduestc.mealsystem.common.Constants;
import com.cduestc.mealsystem.common.DataFactory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {

	private GridView mainFuncsGv;
	private MainFuncAdapter adapter;
	private ArrayList<MainFuncInfo> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViews();
		setListeners();

		list = getMainFuncs();
		adapter = new MainFuncAdapter(this, list);
		mainFuncsGv.setAdapter(adapter);

	}

	private void findViews() {
		mainFuncsGv = (GridView) findViewById(R.id.main_gv);
	}

	private void setListeners() {
		mainFuncsGv.setOnItemClickListener(new MainFuncItemOnClickListener());
	}

	/**
	 * 获取主界面title和pic
	 * 
	 * @return 
	 */
	private ArrayList<MainFuncInfo> getMainFuncs() {
		ArrayList<MainFuncInfo> mainfuncList = new ArrayList<MainFuncInfo>();
		String titles[] = { "点菜", "并台", "转台", "查台", "更新", "设置", "注销" };
		for (int i = 0; i < titles.length; i++) {
			MainFuncInfo mainFuncInfo = new MainFuncInfo();
			mainFuncInfo.setTitle(titles[i]);
			mainfuncList.add(mainFuncInfo);
		}
		return mainfuncList;
	}

	private class MainFuncItemOnClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub

			String mainFunc = (String) view.getTag(R.id.tag_main_func);

			if (Constants.MAIN_FUNCTION_ORDERING.equals(mainFunc)) {
				Intent intent = new Intent(MainActivity.this,
						MealMenuActivity.class);
				startActivity(intent);
			}

		}

	}

}
