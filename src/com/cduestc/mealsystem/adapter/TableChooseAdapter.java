package com.cduestc.mealsystem.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.MainFuncInfo;
import com.cduestc.mealsystem.bean.TableInfo;

public class TableChooseAdapter extends BaseAdapter {
	private Context ctx = null;
	private ArrayList<TableInfo> tableInfoList = null;

	public TableChooseAdapter(Context ctx, ArrayList<TableInfo> tableInfoList) {
		this.ctx = ctx;
		this.tableInfoList = tableInfoList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tableInfoList.size();
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
					R.layout.item_table_choose, null);
			holder = new ViewHolder();
			holder.chooseBtn = (Button) convertView
					.findViewById(R.id.table_choose_btn);
			holder.tableNum = (TextView) convertView
					.findViewById(R.id.table_choose_num_tv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Log.i("tag", "flag = " + tableInfoList.get(position).getFlag());
		if (tableInfoList.get(position).getFlag() == 0) {
			holder.chooseBtn.setText(R.string.notif_vacancy);
		} else {
			holder.chooseBtn.setText(R.string.notif_eating);
		}
		holder.tableNum.setText(String.valueOf(tableInfoList.get(position)
				.getNum() + 1));

		return convertView;
	}

	final class ViewHolder {
		Button chooseBtn;
		TextView tableNum;
	}
}
