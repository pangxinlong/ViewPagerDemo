package com.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	private ViewPager viewPager_main;
	// ViewPager的数据源
	private List<View> list = null;
	// 导航界面中图片的ID
	private int[] imgId ={ R.drawable.img1, R.drawable.img2,
			R.drawable.img3};
	//小圆点控件的父控件
	private RadioGroup dots;
	// 图片下面的小圆点
	private int[] listbutton={R.id.imageView1,R.id.imageView2,R.id.imageView3};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化
		viewPager_main = (ViewPager) findViewById(R.id.viewpager_main);
		dots=(RadioGroup) findViewById(R.id.layout_cotainer);
		
		// 添加适配器
		viewPager_main.setAdapter(new MyAdapter(imgId, this));
		
		dots.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				for(int i=0;i<listbutton.length;i++){
					if(checkedId==listbutton[i]){
						if(i!=viewPager_main.getCurrentItem()){
						viewPager_main.setCurrentItem(i,false);}
					}
						
				}
			}
		});
		//添加监听器
		viewPager_main.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if(dots.getCheckedRadioButtonId()!=listbutton[arg0]){
				((RadioButton)findViewById(listbutton[arg0])).setChecked(true);
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}