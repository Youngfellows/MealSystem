package com.cduestc.mealsystem.ui;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.adapter.OrderDetailsAdapter;
import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.OrderInfo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class OrderFragment extends Fragment {

	private OrderInfo orderInfo;
	private ArrayList<FoodInfo> orderFoodInfoList;
	private ArrayList<FoodInfo> initialFoodInfoList;
	private Button submitBtn;
	private Button cancelSubmitBtn;
	private Button cancelBtn;
	private Button modifyBtn;
	private ListView detailsListView;
	private OrderDetailsAdapter adapter;
	private int type;

	public static final int CHECK_ORDER_DETAILS = 0;
	public static final int SUBMIT_ORDER_DETAILS = 1;

	public static OrderFragment newInstance(int type) {
		OrderFragment of = new OrderFragment();
		Bundle args = new Bundle();
		args.putInt("type", type);
		of.setArguments(args);
		return of;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.orderInfo = ((MealMenuActivity) getActivity()).getOderInfo();
		this.orderFoodInfoList = orderInfo.getOrderFoodInfoList();
		// 保存初始List，点击取消按钮后还原List
		this.initialFoodInfoList = new ArrayList<FoodInfo>();
		for (FoodInfo foodInfo : orderFoodInfoList) {
			FoodInfo newFoodInfo = new FoodInfo();
			FoodInfo.copyFoodInfo(foodInfo, newFoodInfo);
			initialFoodInfoList.add(newFoodInfo);
		}
		// type
		this.type = getArguments().getInt("type");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View contentView = LayoutInflater.from(getActivity()).inflate(
				R.layout.frag_order_details, null);
		findViews(contentView);
		setLiseners();

		// 根据type调整View的显示
		modifyViewDisplay();

		adapter = new OrderDetailsAdapter(getActivity(), orderInfo, type);
		detailsListView.setAdapter(adapter);

		return contentView;
	}

	private void findViews(View parentView) {
		detailsListView = (ListView) parentView
				.findViewById(R.id.check_details_lv);
		cancelBtn = (Button) parentView.findViewById(R.id.cancel_btn);
		modifyBtn = (Button) parentView.findViewById(R.id.modify_btn);
		submitBtn = (Button) parentView.findViewById(R.id.submit_btn);
		cancelSubmitBtn = (Button) parentView
				.findViewById(R.id.cancel_submit_btn);
	}

	private void setLiseners() {
		cancelBtn.setOnClickListener(new OrderFragmentOnclickListener());
		modifyBtn.setOnClickListener(new OrderFragmentOnclickListener());
		submitBtn.setOnClickListener(new OrderFragmentOnclickListener());
		cancelSubmitBtn.setOnClickListener(new OrderFragmentOnclickListener());
	}

	private void modifyViewDisplay() {
		if (type == CHECK_ORDER_DETAILS) {
			// submitBtn.setClickable(false);
			// modifyBtn.setClickable(true);
			// cancelBtn.setClickable(true);
			// submitBtn.setVisibility(View.INVISIBLE);
			// modifyBtn.setVisibility(View.VISIBLE);
			// cancelBtn.setVisibility(View.VISIBLE);
		} else if (type == SUBMIT_ORDER_DETAILS) {
			submitBtn.setClickable(true);
			cancelSubmitBtn.setClickable(true);
			modifyBtn.setClickable(false);
			cancelBtn.setClickable(false);
			submitBtn.setVisibility(View.VISIBLE);
			cancelSubmitBtn.setVisibility(View.VISIBLE);
			modifyBtn.setVisibility(View.INVISIBLE);
			cancelBtn.setVisibility(View.INVISIBLE);
		}
	}

	private class OrderFragmentOnclickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			switch (id) {
			case R.id.cancel_btn:
				// 还原orderInfo里面的foodInfoList
				orderFoodInfoList.clear();
				orderFoodInfoList.addAll(initialFoodInfoList);
				((MealMenuActivity) getActivity()).displayOrderFl(false);
				break;
			case R.id.modify_btn:
				// 保存修改并退出
				changeDetailContent();
				((MealMenuActivity) getActivity()).displayOrderFl(false);
				break;
			case R.id.submit_btn:
				Intent intent = new Intent(getActivity(),
						TableChooseActivity.class);
				intent.putExtra("orderInfo", orderInfo);
				startActivity(intent);
				getActivity().finish();
			case R.id.cancel_submit_btn:
				((MealMenuActivity) getActivity()).displayOrderFl(false);
				break;
			}

		}

	}

	private void changeDetailContent() {
		DetailsFragment df = DetailsFragment.newInstance(0);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.meal_menu_details, df);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.commit();
	}

}
