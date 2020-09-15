package yincheng.tinytank.android_Q_A._1_100._6;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import yincheng.tinytank.R;

public class SharedMemoryCommunicationActivity extends AppCompatActivity {
	private int sharedData = 0;
	private ExecutorService executor = Executors.newCachedThreadPool();

	private synchronized void plusplus() {
		sharedData++;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_communication);
		for (int i = 0; i < 10000; i++) {
			executor.execute(new WorkerRunnable());
		}
		System.out.println("-------asdf--" + sharedData);
	}

	class WorkerRunnable implements Runnable {
		@Override
		public void run() {
			plusplus();
		}
	}
}