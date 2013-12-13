package com.cduestc.mealsystem.ui;

import com.cduestc.mealsystem.R;

import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SubmitOrderFragment extends Fragment {

	private Button cancelBtn;
	private Button modifyBtn;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		getActivity().setRequestedOrientation(
				ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View contentView = LayoutInflater.from(getActivity()).inflate(
				R.layout.activity_order_details, null);
		findViews(contentView);
		setLiseners();

		return contentView;
	}

	private void findViews(View parentView) {
		cancelBtn = (Button) parentView.findViewById(R.id.cancel_btn);
		modifyBtn = (Button) parentView.findViewById(R.id.modify_btn);
	}

	private void setLiseners() {
		cancelBtn.setOnClickListener(new OrderFragmentOnclickListener());
		modifyBtn.setOnClickListener(new OrderFragmentOnclickListener());
	}

	private class OrderFragmentOnclickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			switch (id) {
			case R.id.cancel_btn:
				((MealMenuActivity) getActivity()).displayOrderFl(false);
				break;
			case R.id.modify_btn:

				break;
			}

		}

	}

}
