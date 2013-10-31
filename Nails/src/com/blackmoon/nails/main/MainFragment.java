package com.blackmoon.nails.main;

import com.blackmoon.nails.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * 
 * @author blackmoon 2013-10-31
 */
public class MainFragment extends Fragment {
	private GridView mGridView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		setupViews();
	}

	protected View findViewById(int id) {
		return getView().findViewById(id);
	}

	private void setupViews() {
		mGridView = (GridView) findViewById(R.id.grid);
		mGridView.setAdapter(new NailsFlowerAdapter());
	};
}
