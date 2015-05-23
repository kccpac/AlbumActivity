package com.example.albumactivity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class AlbumActivity extends Activity {

	private static final String Tag = AlbumActivity.class.getCanonicalName();
	
    private Integer[] mImageIds = {
    		 R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7
    };

	private GridView mGridView;

	private AlbumAdapter mAdapter;
	protected List<Integer> mAlbumList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_album);
		HorizontalScrollView  v = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
	DisplayMetrics metrics = getResources().getDisplayMetrics();
		Log.i(Tag, "density:" + metrics.density + " widthPixel: "+metrics.widthPixels + " heightPixel: "+metrics.heightPixels);
		mAlbumList = new ArrayList<Integer>();
		mAdapter = new AlbumAdapter(mAlbumList);
		mGridView = (GridView)findViewById(R.id.gridView1);
		mGridView.setAdapter(mAdapter);
	
		LayoutInflater inflater;

	    inflater=getLayoutInflater();
	    LinearLayout inLay=(LinearLayout) findViewById(R.id.innerLay);

		for (int id: mImageIds)
		{
			ImageView imv = new ImageView(this);
			imv.setImageResource(id);	
			imv.setId(id);
			imv.setOnClickListener(new OnClickListener()
			{
	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.i(Tag, "view " + v.getId());
					Log.i(Tag, "dimension (" + v.getWidth() + "," + v.getHeight() + ")");
					if (v.getAlpha() <= 0.2F)
					{
						v.setAlpha(1.0F);
						if (mAlbumList.contains(v.getId()))
						{
							mAlbumList.remove((Object)v.getId());
						}						
					}
					else
					{
						v.setAlpha(0.2F);
						mAlbumList.add(v.getId());
					}
					mAdapter.notifyDataSetChanged();				
				}			
			});
			inLay.addView(imv);
		}

		v.setHorizontalScrollBarEnabled(true);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.album, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
