package com.blackmoon.nails.main;

import com.blackmoon.nails.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * 数据到视图的适配器
 * 
 * @author blackmoon 2013-10-31
 */
public class NailsFlowerAdapter extends BaseAdapter {

	/**
	 * 单元格的个数
	 */
	@Override
	public int getCount() {
		return 20;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * 一个单元格的视图
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.img_item, null);
			holder.mFlower = (ImageView) convertView.findViewById(R.id.img);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	/**
	 * 视图缓存
	 * 
	 * @author blackmoon 2013-10-31
	 */
	final static class ViewHolder {
		ImageView mFlower;
	}

}
