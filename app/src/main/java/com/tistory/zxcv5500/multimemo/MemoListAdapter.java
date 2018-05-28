package com.tistory.zxcv5500.multimemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxcv5500 on 2018-05-29.
 */

public class MemoListAdapter extends BaseAdapter {

	private Context mContext;

	private List<MemoListItem> mItems = new ArrayList<>();


	public MemoListAdapter(Context context) {
		mContext = context;
	}

	public void clear() {
	    mItems.clear();
	}

	public void addItem(MemoListItem it) {
	    mItems.add(it);
	}

	public void setListItems(List<MemoListItem> lit) {
	    mItems = lit;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	public boolean areAllItemsSelectable() {
	    return false;
	}

	public boolean isSelectable(int position) {
		try {
			return mItems.get(position).isSelectable();
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		MemoListItemView itemView;
		if (convertView == null) {
			itemView = new MemoListItemView(mContext);
		} else {
			itemView = (MemoListItemView) convertView;
		}


		// set current item data
		itemView.setContents(0, ((String) mItems.get(position).getData(0)));
		itemView.setContents(1, ((String) mItems.get(position).getData(1)));
		itemView.setContents(2, ((String) mItems.get(position).getData(3)));
		itemView.setContents(3, ((String) mItems.get(position).getData(5)));

		itemView.setMediaState(mItems.get(position).getData(7), mItems.get(position).getData(9));

		return itemView;
	}
}
