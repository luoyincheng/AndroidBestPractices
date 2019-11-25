package yincheng.tinytank.android_Q_A._1_100._1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import yincheng.tinytank.R;

import static yincheng.tinytank.android_Q_A.constants.LIFE_CYCLE;

public class LifeCycleFragment extends Fragment {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(LIFE_CYCLE, "(fragment):onCreate");
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		Log.i(LIFE_CYCLE, "(fragment):onCreateView");
		return inflater.inflate(R.layout.fragment_life_cycle, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.i(LIFE_CYCLE, "(fragment):onViewCreated");
	}

	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		Log.i(LIFE_CYCLE, "(fragment):onAttach");
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i(LIFE_CYCLE, "(fragment):onActivityCreated");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.i(LIFE_CYCLE, "(fragment):onStart");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(LIFE_CYCLE, "(fragment):onResume");
	}

//	@Override
//	public void onSaveInstanceState(@NonNull Bundle outState) {
//		super.onSaveInstanceState(outState);
//		Log.i(LIFE_CYCLE, "(fragment):onSaveInstanceState");
//	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(LIFE_CYCLE, "(fragment):onPause");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(LIFE_CYCLE, "(fragment):onStop");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(LIFE_CYCLE, "(fragment):onDestroy");

	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.i(LIFE_CYCLE, "(fragment):onDestroyView");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.i(LIFE_CYCLE, "(fragment):onDetach");
	}
}
