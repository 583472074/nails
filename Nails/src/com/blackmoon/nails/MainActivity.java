package com.blackmoon.nails;

import com.blackmoon.nails.base.BaseActivity;
import com.blackmoon.nails.main.MainFragment;

import android.os.Bundle;

/**
 * 应用程序的主Activity
 * 
 * @author blackmoon 2013-10-31
 */
public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentFragment(MainFragment.class, savedInstanceState);
        setContentFragment(MainFragment.class, savedInstanceState);
    }

    // public void setContentFragment(Class<? extends Fragment> clazz,
    // Bundle args) {
    // Fragment fragment = Fragment.instantiate(this, clazz.getName(), args);
    //
    // FragmentManager fm = getFragmentManager();
    // fm.beginTransaction().replace(android.R.id.content, fragment).commit();
    // }
}
