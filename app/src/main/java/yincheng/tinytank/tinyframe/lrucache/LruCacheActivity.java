package yincheng.tinytank.tinyframe.lrucache;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;
import yincheng.tinytank.databinding.ActivityDisklrucacheBinding;


public class LruCacheActivity extends AppCompatActivity {
	private ActivityDisklrucacheBinding mActivityDiskLruCacheBinding;
	private LruCacheViewModel mLruCacheViewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ViewModel
		if (mLruCacheViewModel == null) {
			mLruCacheViewModel = new LruCacheViewModel(this);
		}
		if (mActivityDiskLruCacheBinding == null) {
			mActivityDiskLruCacheBinding = ActivityDisklrucacheBinding.bind(getLayoutInflater().inflate(R.layout.activity_disklrucache, null, false));
		}
		//bind ViewModel to View
		mActivityDiskLruCacheBinding.setLruViewModel(mLruCacheViewModel);
		setContentView(mActivityDiskLruCacheBinding.getRoot());
		mLruCacheViewModel.onActivityCreated();
	}
}
