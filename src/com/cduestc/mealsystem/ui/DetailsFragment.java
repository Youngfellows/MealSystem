package com.cduestc.mealsystem.ui;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.adapter.DetailsAdapter;
import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.MainMenuInfo;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.common.DataFactory;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.GridView;

public class DetailsFragment extends Fragment {

	private OrderInfo orderInfo;
	private ArrayList<FoodInfo> foodInfoList;
	private DetailsAdapter adapter;

	/**
	 * * Create a new instance of DetailsFragment, initialized to * show the
	 * text at 'index'.
	 */
	public static DetailsFragment newInstance(int index) {
		DetailsFragment f = new DetailsFragment();
		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.orderInfo = ((MealMenuActivity) activity).getOderInfo();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View contentView = LayoutInflater.from(getActivity()).inflate(
				R.layout.frag_detail, null);
		GridView gv = (GridView) contentView.findViewById(R.id.detail_gv);
		gv.setOnItemClickListener(new DetailsOnItemClickListener());

		// 获取点击位置
		int index = getArguments().getInt("index");

		// 获取主菜单目录List
		ArrayList<MainMenuInfo> mainMenuList = DataFactory.getMainMenuList();

		// 获取主菜单对应的详细菜单List
		foodInfoList = DataFactory.getDetailMenu(mainMenuList.get(index)
				.getId());

		adapter = new DetailsAdapter(getActivity(),
				foodInfoList, orderInfo);
		gv.setAdapter(adapter);

		return contentView;
	}
	
	private class DetailsOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			CheckBox cb = (CheckBox) view.findViewById(R.id.item_detail_add_cb);
			FoodInfo foodInfo = foodInfoList.get(position);
			if (cb.isChecked()) {
				orderInfo.removeFood(foodInfo);
			} else {
				orderInfo.addFood(foodInfo);
			}
			cb.setChecked(!cb.isChecked());
		}

	}

}
