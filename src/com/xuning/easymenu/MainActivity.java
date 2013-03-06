package com.xuning.easymenu;




import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*设置左侧菜单*/
		MenuListAdapter menuListAdapter;
		ListView mListView;
		
		mListView = (ListView) findViewById(R.id.main_list);
		menuListAdapter = new MenuListAdapter(MainActivity.this);
		mListView.setAdapter(menuListAdapter);
		menuListAdapter.notifyDataSetChanged();
		
		/*设置右侧内容*/
		
		final LinearLayout mainlayout = (LinearLayout) findViewById(R.id.main_layout);
		final LayoutInflater inflater = LayoutInflater.from(this);
		LinearLayout adlayout = (LinearLayout) inflater.inflate(
				R.layout.view_ad, null).findViewById(R.id.ad_layout);
		mainlayout.removeAllViews();
		mainlayout.addView(adlayout);
		
		/*获取分辨率*/
		 DisplayMetrics dm = new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(dm);
		 int width = dm.widthPixels;
		 int height = dm.heightPixels;
		 Log.i("分辨率", width+"*"+height);
		 
		/*左侧菜单点击*/
		 mListView.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					switch(arg2){
					case 0:LinearLayout adlayout = (LinearLayout) inflater.inflate(
							R.layout.view_ad, null).findViewById(R.id.ad_layout);
							mainlayout.removeAllViews();
							mainlayout.addView(adlayout);
							break;
					case 1: 
							LinearLayout recommendationlayout = (LinearLayout) inflater.inflate(
								R.layout.view_recommendation, null).findViewById(R.id.recommendation_layout);
							mainlayout.removeAllViews();
							mainlayout.addView(recommendationlayout);
							break;
					case 2: 
						LinearLayout menulayout = (LinearLayout) inflater.inflate(
							R.layout.view_menu, null).findViewById(R.id.menu_layout);
						mainlayout.removeAllViews();
						mainlayout.addView(menulayout);
						break;
					case 3: 
						LinearLayout listlayout = (LinearLayout) inflater.inflate(
							R.layout.view_list, null).findViewById(R.id.list_layout);
						mainlayout.removeAllViews();
						mainlayout.addView(listlayout);
						break;
					case 4: 
						LinearLayout recommendation = (LinearLayout) inflater.inflate(
							R.layout.view_user, null).findViewById(R.id.user_layout);
						mainlayout.removeAllViews();
						mainlayout.addView(recommendation);
						break;
					}
				}
	        	
	        });

		
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
