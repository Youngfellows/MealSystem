package com.cduestc.mealsystem.ui;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.common.Constants;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MealMenuActivity extends Activity {

	public OrderInfo orderInfo;

	private Button backBtn;
	private Button checkOrderBtn;
	private Button submitOrderBtn;
	private FrameLayout orderFl;
	private Bundle tableInfoBundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meal_menu);

		orderInfo = new OrderInfo();
		tableInfoBundle = getIntent().getExtras();

		findViews();
		setLiseners();

	}

	private void findViews() {
		backBtn = (Button) findViewById(R.id.back_btn);
		checkOrderBtn = (Button) findViewById(R.id.check_order_btn);
		submitOrderBtn = (Button) findViewById(R.id.submit_order_btn);
		orderFl = (FrameLayout) findViewById(R.id.meal_menu_order);
	}

	private void setLiseners() {
		backBtn.setOnClickListener(new MealMenuOnClickListener());
		checkOrderBtn.setOnClickListener(new MealMenuOnClickListener());
		submitOrderBtn.setOnClickListener(new MealMenuOnClickListener());
	}

	public void displayOrderFl(boolean display) {
		if (display) {
			orderFl.setVisibility(View.VISIBLE);
		} else {
			orderFl.setVisibility(View.GONE);
		}
	}

	public OrderInfo getOderInfo() {
		return this.orderInfo;
	}

	private class MealMenuOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			Bundle args = new Bundle();
			OrderFragment sof;
			FragmentTransaction ft;
			switch (id) {
			case R.id.back_btn:
				checkOrder();
				break;
			case R.id.check_order_btn:
				// 跳转到订单详情界面
				args.putInt("type", OrderFragment.CHECK_ORDER_DETAILS);
				sof = OrderFragment.newInstance();
				sof.setArguments(args);
				ft = getFragmentManager().beginTransaction();
				ft.replace(R.id.meal_menu_order, sof);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
				displayOrderFl(true);
				break;
			case R.id.submit_order_btn:
				// 放置餐桌信息
				if (tableInfoBundle != null) {
					tableInfoBundle.putInt("type",
							OrderFragment.SUBMIT_ORDER_DETAILS);
					args = tableInfoBundle;
				} else {
					args.putInt("type", OrderFragment.SUBMIT_ORDER_DETAILS);
				}
				// 提交订单到厨房，保存订单到数据库
				sof = OrderFragment.newInstance();
				sof.setArguments(args);
				ft = getFragmentManager().beginTransaction();
				ft.replace(R.id.meal_menu_order, sof);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
				displayOrderFl(true);
				break;
			}
		}
	}

	/**
	 * 检查订单，订单被支付或者订单为空直接退出，没有支付弹出提示
	 */
	private void checkOrder() {
		if (orderInfo.getIsPaid() == OrderInfo.PAID
				|| orderInfo.getOrderFoodInfoList().isEmpty()) {
			finish();
		} else {
			// 弹出提示，询问是否放弃订单
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			checkOrder();
		}
		return super.onKeyDown(keyCode, event);
	}

}
