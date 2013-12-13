package com.cduestc.mealsystem.ui;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.MainMenuInfo;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.common.DataFactory;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

	public OrderInfo orderInfo;

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

		// 获取点击位置
		int index = getArguments().getInt("index");

		// 获取主菜单目录List
		ArrayList<MainMenuInfo> mainMenuList = DataFactory.getMainMenuList();

		// 获取主菜单对应的详细菜单List
		ArrayList<FoodInfo> foodInfoList = DataFactory
				.getDetailMenu(mainMenuList.get(index).getId());

		DetailsAdapter adapter = new DetailsAdapter(getActivity(), foodInfoList);
		gv.setAdapter(adapter);

		return contentView;
	}

	private class DetailsAdapter extends BaseAdapter {

		private Context ctx;
		private ArrayList<FoodInfo> list;

		public DetailsAdapter(Context ctx, ArrayList<FoodInfo> list) {
			this.ctx = ctx;
			this.list = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			final ViewHolder holder;
			if (convertView == null) {
				convertView = LayoutInflater.from(ctx).inflate(
						R.layout.item_detail, null);
				holder = new ViewHolder();
				holder.pic = (ImageView) convertView
						.findViewById(R.id.item_detail_pic_iv);
				holder.name = (TextView) convertView
						.findViewById(R.id.item_detail_name_tv);
				holder.price = (TextView) convertView
						.findViewById(R.id.item_detail_price_tv);
				holder.add = (CheckBox) convertView
						.findViewById(R.id.item_detail_add_cb);
				holder.add
						.setOnCheckedChangeListener(new OnCheckedChangeListener() {

							@Override
							public void onCheckedChanged(
									CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								if (isChecked) {
									DetailsFragment.this.orderInfo.addFood(list
											.get(position));
								} else {
									DetailsFragment.this.orderInfo
											.removeFood(list.get(position));
								}
							}
						});
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.pic.setImageDrawable((Drawable) list.get(position).getPic());
			holder.name.setText(list.get(position).getName());
			holder.price.setText(String.valueOf(list.get(position).getPrice()));
			holder.add.setChecked(getChecked(list.get(position).getId()));

			return convertView;
		}

		final class ViewHolder {
			ImageView pic;
			TextView name;
			TextView price;
			CheckBox add;
		}

		/**
		 * 判断id是否在订单内
		 * 
		 * @param id
		 *            食物的id
		 * @return 包含，返回true，不包含，返回false
		 */
		private boolean getChecked(String id) {
			for (FoodInfo foodInfo : DetailsFragment.this.orderInfo
					.getOrderList()) {
				if (foodInfo.getId().equals(id)) {
					return true;
				}
			}
			return false;
		}
	}

}
