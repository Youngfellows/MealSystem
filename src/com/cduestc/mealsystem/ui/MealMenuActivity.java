package com.cduestc.mealsystem.ui;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.OrderInfo;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MealMenuActivity extends Activity {

	public OrderInfo orderInfo;

	private Button backBtn;
	private Button checkOrderBtn;
	private Button submitOrderBtn;

	private FrameLayout orderFl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meal_menu);

		orderInfo = new OrderInfo();

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
			switch (id) {
			case R.id.back_btn:
				checkOrder();
				break;
			case R.id.check_order_btn:
				// ��ת�������������
				// Intent OrderDetailsIntent = new Intent(MealMenuActivity.this,
				// OrderDtailsActivity.class);
				// startActivity(OrderDetailsIntent);
				SubmitOrderFragment sof = new SubmitOrderFragment();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.meal_menu_order, sof);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
				displayOrderFl(true);
				break;
			case R.id.submit_order_btn:
				// �ύ���������������涩�������ݿ�
				break;
			}
		}

	}

	/**
	 * ��鶩�����������������߶���Ϊ��ֱ���˳���û�д���������ʾ
	 */
	private void checkOrder() {
		if (orderInfo.isTake() || orderInfo.getOrderList().isEmpty()) {
			finish();
		} else {
			// ������ʾ��ѯ���Ƿ��������
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