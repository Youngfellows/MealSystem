package com.cduestc.mealsystem.ui;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.adapter.TableChooseAdapter;
import com.cduestc.mealsystem.bean.OrderInfo;
import com.cduestc.mealsystem.bean.TableInfo;
import com.cduestc.mealsystem.common.DataFactory;
import com.cduestc.mealsystem.common.OrderInfoManger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class TableChooseActivity extends Activity {

	private GridView gridView;
	private TableChooseAdapter adapter;
	private ArrayList<TableInfo> tableInfoList;
	private OrderInfoManger orderInfoManger;
	private OrderInfo orderInfo;
	private String fromActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_table);

		orderInfoManger = OrderInfoManger.getInstance(this);
		orderInfo = getIntent().getParcelableExtra("orderInfo");
		tableInfoList = DataFactory.getTableInfoList();
		fromActivity = getIntent().getStringExtra("fromActivity");

		gridView = (GridView) findViewById(R.id.choose_table_gv);
		adapter = new TableChooseAdapter(TableChooseActivity.this,
				tableInfoList);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new TableChooseOnItemClickListener());

	}

	private class TableChooseOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			if ("MainActivity".equals(fromActivity)) {
				return;
			}
			TableInfo tableInfo = tableInfoList.get(position);
			if (tableInfo.getFlag() == 0) {
				tableInfo.setFlag(1);
				if (orderInfoManger.addToUnpayOrderList(orderInfo)) {
					Toast.makeText(TableChooseActivity.this,
							R.string.notif_submit_success, Toast.LENGTH_SHORT)
							.show();
					Intent intent = new Intent(TableChooseActivity.this,
							MainActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
					startActivity(intent);
					TableChooseActivity.this.finish();
				}
			} else {
				Toast.makeText(TableChooseActivity.this,
						R.string.notif_occupied, Toast.LENGTH_SHORT).show();
			}
		}

	}

}
