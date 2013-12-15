package com.cduestc.mealsystem.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.ui.OrderFragment;

public class OrderDetailsAdapter extends BaseAdapter {
	private Context ctx;
	private OrderInfo orderInfo;
	private int type;
	private ArrayList<FoodInfo> orderFoodInfoList;

	public OrderDetailsAdapter(Context ctx, OrderInfo orderInfo, int type) {
		this.ctx = ctx;
		this.orderInfo = orderInfo;
		this.type = type;
		orderFoodInfoList = orderInfo.getOrderFoodInfoList();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return orderFoodInfoList.size();
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.item_order_details, null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView
					.findViewById(R.id.item_check_details_name_tv);
			holder.price = (TextView) convertView
					.findViewById(R.id.item_check_details_price_tv);
			holder.add = (Button) convertView
					.findViewById(R.id.item_check_details_add_btn);
			holder.sub = (Button) convertView
					.findViewById(R.id.item_check_details_sub_btn);
			holder.num = (TextView) convertView
					.findViewById(R.id.item_check_details_num_tv);
			holder.del = (Button) convertView
					.findViewById(R.id.item_check_details_del_btn);
			// setListeners
			holder.add.setOnClickListener(new CheckOrderOnClickListener());
			holder.sub.setOnClickListener(new CheckOrderOnClickListener());
			holder.del.setOnClickListener(new CheckOrderOnClickListener());
			// changeViewDisplay
			if (type == OrderFragment.CHECK_ORDER_DETAILS) {
				
			} else if (type == OrderFragment.SUBMIT_ORDER_DETAILS) {
				holder.add.setVisibility(View.GONE);
				holder.sub.setVisibility(View.GONE);
				holder.del.setVisibility(View.GONE);
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(orderFoodInfoList.get(position).getName());
		holder.price.setText(String.valueOf(orderFoodInfoList.get(position)
				.getPrice()));
		holder.num.setText(String.valueOf(orderFoodInfoList.get(position)
				.getNum()));

		holder.add.setTag(R.id.tag_position, position);
		holder.sub.setTag(R.id.tag_position, position);
		holder.del.setTag(R.id.tag_position, position);

		return convertView;
	}

	final class ViewHolder {
		TextView name;
		TextView price;
		Button add;
		Button sub;
		TextView num;
		Button del;
	}

	private class CheckOrderOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			int position = (Integer) v.getTag(R.id.tag_position);
			FoodInfo foodInfo = orderFoodInfoList.get(position);
			switch (id) {
			case R.id.item_check_details_add_btn:
				foodInfo.addNum();
				break;
			case R.id.item_check_details_sub_btn:
				foodInfo.subNum();
				break;
			case R.id.item_check_details_del_btn:
				orderInfo.removeFood(foodInfo);
				break;
			}
			// 更新ListView数据
			notifyDataSetChanged();
		}

	}

}
