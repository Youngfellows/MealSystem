package com.cduestc.mealsystem.ui;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.adapter.MainFuncAdapter;
import com.cduestc.mealsystem.bean.MainFuncInfo;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.common.Constants;
import com.cduestc.mealsystem.common.DataFactory;
import com.cduestc.mealsystem.common.OrderInfoManger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private GridView mainFuncsGv;
	private MainFuncAdapter adapter;
	private ArrayList<MainFuncInfo> list;
	private OrderInfoManger orderManger;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		orderManger = OrderInfoManger.getInstance(this);

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
		String titles[] = { "点菜", "结算", "并台", "转台", "查台", "更新", "设置", "注销" };
		for (int i = 0; i < titles.length; i++) {
			MainFuncInfo mainFuncInfo = new MainFuncInfo();
			mainFuncInfo.setTitle(titles[i]);
			mainfuncList.add(mainFuncInfo);
		}
		return mainfuncList;
	}

	private EditText et;

	private class MainFuncItemOnClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub

			String mainFunc = (String) view.getTag(R.id.tag_main_func);
			Intent intent;
			if (Constants.MAIN_FUNCTION_ORDERING.equals(mainFunc)) {
				intent = new Intent(MainActivity.this, MealMenuActivity.class);
				startActivity(intent);
			} else if (Constants.MAIN_FUNCTION_CHECKOUT.equals(mainFunc)) {
				RelativeLayout editView = (RelativeLayout) getLayoutInflater().inflate(
						R.layout.check_out_edit_view, null);
				et = (EditText) editView.findViewById(R.id.check_out_ev);
				AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
						.setView(editView).create();
				dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消",
						new MyAlertDialogOnCLickListener());
				dialog.setButton(AlertDialog.BUTTON_POSITIVE, "查询",
						new MyAlertDialogOnCLickListener());
				dialog.show();
				et.requestFocus();
			} else if (Constants.MAIN_FUNCTION_FREE_TABEL.equals(mainFunc)) {
				intent = new Intent(MainActivity.this,
						TableChooseActivity.class);
				startActivity(intent);
			}

		}

	}

	private class MyAlertDialogOnCLickListener implements
			DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			switch (which) {
			case AlertDialog.BUTTON_NEGATIVE:

				break;
			case AlertDialog.BUTTON_POSITIVE:
				String orderId = et.getText().toString();
				if (orderManger.quiryOrder(orderId)) {
					Intent intent = new Intent(MainActivity.this,
							OrderDetailsActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this,
							R.string.notif_order_not_found, Toast.LENGTH_SHORT)
							.show();
				}
				break;
			}
		}

	}

}
