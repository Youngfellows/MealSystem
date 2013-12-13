package com.cduestc.mealsystem.ui;

import java.util.ArrayList;

import com.cduestc.mealsystem.R;
import com.cduestc.mealsystem.bean.MainMenuInfo;
import com.cduestc.mealsystem.common.DataFactory;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeaderFragment extends ListFragment {

	private int mCurCheckPosition = 0;
	private int mShownCheckPosition = -1;

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		// super.onListItemClick(l, v, position, id);
		showDetails(position);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		ArrayList<MainMenuInfo> mainMenuList = DataFactory.getMainMenuList();
		ArrayList<String> list = new ArrayList<String>();
		for (MainMenuInfo mainMenuInfo : mainMenuList) {
			list.add(mainMenuInfo.getName());
		}
		setListAdapter(new ArrayAdapter(getActivity(),
				android.R.layout.simple_list_item_activated_1, list));
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		showDetails(mCurCheckPosition);
	}

	/**
	 * œ‘ ælistview item œÍ«È
	 */
	private void showDetails(int index) {
		mCurCheckPosition = index;
		getListView().setItemChecked(index, true);

		if (mShownCheckPosition != mCurCheckPosition) {
			DetailsFragment df = DetailsFragment.newInstance(index);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.meal_menu_details, df);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			mShownCheckPosition = index;
		}
	}

}
