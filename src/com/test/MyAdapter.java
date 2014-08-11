package com.test;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class MyAdapter extends PagerAdapter {

	private int list[] = null;
	private Context context = null;

	public MyAdapter(int list[], Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	// 此方法必须被重写
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(container.getContext());
		imageView.setImageResource(list[position]);
		imageView.setScaleType(ScaleType.FIT_XY);
		container.addView(imageView);
		return imageView;
	}

	// 此方法必须被重写
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		//container.removeViewAt(position);

	}

}