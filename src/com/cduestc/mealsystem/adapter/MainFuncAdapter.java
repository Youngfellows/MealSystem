package com.cduestc.mealsystem.adapter;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.MainFuncInfo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFuncAdapter extends BaseAdapter {

	private Context ctx = null;
	private ArrayList<MainFuncInfo> list = null;

	public MainFuncAdapter(Context ctx, ArrayList<MainFuncInfo> list) {
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.item_main_func, null);
			holder = new ViewHolder();
			holder.pic = (ImageView) convertView
					.findViewById(R.id.main_func_iv);
			holder.title = (TextView) convertView
					.findViewById(R.id.main_func_tv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.pic.setImageDrawable((Drawable) list.get(position).getPic());
		holder.title.setText(list.get(position).getTitle());

		convertView.setTag(R.id.tag_main_func, list.get(position).getTitle());

		return convertView;
	}

	final class ViewHolder {
		ImageView pic;
		TextView title;
	}

}
