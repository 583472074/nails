package com.blackmoon.nails;

import com.blackmoon.nails.main.MainFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * 应用程序的主Activity
 * 
 * @author blackmoon 2013-10-31
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentFragment(MainFragment.class, savedInstanceState);
	}

	protected void setContentFragment(Class<? extends Fragment> clazz,
			Bundle args) {
		Fragment fragment = Fragment.instantiate(this, clazz.getName(), args);

		FragmentManager fm = getFragmentManager();
		fm.beginTransaction().replace(android.R.id.content, fragment).commit();
	}
}
