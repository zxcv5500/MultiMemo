package com.tistory.zxcv5500.multimemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tistory.zxcv5500.multimemo.common.TitleBitmapButton;

public class MultiMemoActivity extends AppCompatActivity {

	public static final String TAG = "MultiMemoActivity";

	ListView mMemoListView;

	MemoListAdapter mMemoListAdapter;

	int mMemoCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mMemoListView = (ListView) findViewById(R.id.memoList);
		mMemoListAdapter = new MemoListAdapter(this);
		mMemoListView.setAdapter(mMemoListAdapter);
		mMemoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
				viewMemo(position);
			}
		});

		// 새 메모 버튼 설정
		TitleBitmapButton newMemoBtn = (TitleBitmapButton) findViewById(R.id.newMemoBtn);
		newMemoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d(TAG, "newMemoBtn clicked.");
			}
		});

		// 닫기 버튼 설정
		TitleBitmapButton closeBtn = (TitleBitmapButton) findViewById(R.id.closeBtn);
		closeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});


		loadMemoListData();

	}

	private void loadMemoListData() {
		MemoListItem aItem = new MemoListItem("1", "2018-05-29 02:29", "오늘은 좋은 날!",
				null, null,
				null, null,
				null, null,
				null, null
				);

		mMemoListAdapter.addItem(aItem);
		mMemoListAdapter.notifyDataSetChanged();
	}

	private void viewMemo(int position) {

	}
}
