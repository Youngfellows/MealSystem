package com.cduestc.mealsystem.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.FoodInfo;
import com.cduestc.mealsystem.bean.OrderInfo;

public class DetailsAdapter extends BaseAdapter {

	private Context ctx;
	private ArrayList<FoodInfo> list;
	private OrderInfo orderInfo;

	public DetailsAdapter(Context ctx, ArrayList<FoodInfo> list,
			OrderInfo orderInfo) {
		this.ctx = ctx;
		this.list = list;
		this.orderInfo = orderInfo;
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
	public View getView(final int position, View convertView, ViewGroup parent) {
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
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.pic.setImageDrawable((Drawable) list.get(position).getPic());
		holder.name.setText(list.get(position).getName());
		holder.price.setText(String.valueOf(list.get(position).getPrice()));
		holder.add.setChecked(checkAdd(list.get(position).getId()));

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
	private boolean checkAdd(String id) {
		for (FoodInfo foodInfo : orderInfo.getOrderFoodInfoList()) {
			if (foodInfo.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
}
