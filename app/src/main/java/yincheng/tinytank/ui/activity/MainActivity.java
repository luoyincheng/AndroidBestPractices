package yincheng.tinytank.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.List;

import yincheng.tinytank.R;
import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;
import yincheng.tinytank.view.FontTextView;

import static yincheng.tinytank.provider.ItemHolderProvider.mainList;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:01 13:51
 * Github : yincheng.luo
 */

public class MainActivity extends GenericActivityWithRecyclerView {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		toolbar_title.setOnClickListener(v -> {
			startActivity(new Intent(MainActivity.this, AlignmentTestActivity.class));
		});
	}

	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return mainList;
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Toast.makeText(genericAppCompatActivityContext, "onNewIntent", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void prepareData() {
		super.prepareData();
		toolbar_title.setText(R.string.app_name);
	}

	@Override
	public void onBackClick() {
	}

	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onStart");

	}

	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onResume");

	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onStop");

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onDestroy");

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onSaveInstanceState:outState");
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		super.onSaveInstanceState(outState, outPersistentState);
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onSaveInstanceState:PersistableBundle");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onRestoreInstanceState:outState");
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onRestoreInstanceState(savedInstanceState, persistentState);
		System.out.println("－－－－－－－－－－－－－－－－－－－－－－onRestoreInstanceState:PersistableBundle");
	}
}