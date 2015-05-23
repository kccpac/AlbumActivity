package com.example.albumactivity;

import java.util.List;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class AlbumAdapter extends BaseAdapter
{

	 private static final String Tag = AlbumAdapter.class.getCanonicalName();
	List<Integer> mAlbumList;
	public AlbumAdapter( List<Integer> albumList)
	{
		super();
		mAlbumList = albumList;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		Log.i(Tag, "getCount " +  mAlbumList.size());
		return mAlbumList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		Log.i(Tag, "position");
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		Log.i(Tag, "getItemId " + position);
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.i(Tag, "getView " + position);
		
		ImageView imv = new ImageView(parent.getContext());
		int id = mAlbumList.get(position);
		imv.setImageResource(id);	
		imv.setId(id);
		imv.setScaleType(ScaleType.FIT_XY);
		return imv;
	}
	
	public void getDetail()
	{
		Log.i(Tag, "getDetail ");
	}
}
	
