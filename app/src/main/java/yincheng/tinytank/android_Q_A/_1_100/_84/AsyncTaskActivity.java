package yincheng.tinytank.android_Q_A._1_100._84;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import yincheng.tinytank.R;

public class AsyncTaskActivity extends AppCompatActivity {
	TextView textView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynctask_test);
		textView = findViewById(R.id.tv_show);
		findViewById(R.id.btn_download_single_thread).setOnClickListener(v -> {
			String[] urls = {
					"https://cdn.pixabay.com/photo/2013/08/20/15/47/sunset-174276_1280.jpg",
					"https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_1280.jpg",
					"https://cdn.pixabay.com/photo/2014/09/14/18/04/dandelion-445228_1280.jpg",
					"https://cdn.pixabay.com/photo/2014/09/03/20/15/legs-434918_1280.jpg",
					"https://cdn.pixabay.com/photo/2017/02/08/17/24/butterfly-2049567_1280.jpg",
					"https://cdn.pixabay.com/photo/2014/08/29/03/02/horse-430441_1280.jpg"
			};
			DownloadTask singleThreadTask = new DownloadTask();
			singleThreadTask.execute(urls);
		});
		findViewById(R.id.btn_cancel_download).setOnClickListener(view -> {
//			singleDownloadTask.cancel(true);
		});
		findViewById(R.id.btn_download_multi_thread).setOnClickListener(v -> {
			DownloadTask multiThreadTask1 = new DownloadTask();
			multiThreadTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://cdn.pixabay.com/photo/2013/08/20/15/47/sunset-174276_1280.jpg");

			DownloadTask multiThreadTask2 = new DownloadTask();
			multiThreadTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_1280.jpg");

			DownloadTask multiThreadTask3 = new DownloadTask();
			multiThreadTask3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://cdn.pixabay.com/photo/2014/09/14/18/04/dandelion-445228_1280.jpg");

			DownloadTask multiThreadTask4 = new DownloadTask();
			multiThreadTask4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://cdn.pixabay.com/photo/2014/09/03/20/15/legs-434918_1280.jpg");

			DownloadTask multiThreadTask5 = new DownloadTask();
			multiThreadTask5.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://cdn.pixabay.com/photo/2017/02/08/17/24/butterfly-2049567_1280.jpg");

			DownloadTask multiThreadTask6 = new DownloadTask();
			multiThreadTask6.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://cdn.pixabay.com/photo/2014/08/29/03/02/horse-430441_1280.jpg");
		});
	}

	//public abstract class AsyncTask<Params, Progress, Result>
	//在此例中，Params泛型是String类型，Progress泛型是Object类型，Result泛型是Long类型
	private class DownloadTask extends AsyncTask<String, Object, Long> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			textView.setText("开始下载...");
		}

		@Override
		protected Long doInBackground(String... params) {
			//totalByte表示所有下载的文件的总字节数
			long totalByte = 0;
			//params是一个String数组
			for (String url : params) {
				//遍历Url数组，依次下载对应的文件
				Object[] result = downloadSingleFile(url);
				int byteCount = (int) result[0];
				totalByte += byteCount;
				//在下载完一个文件之后，我们就把阶段性的处理结果发布出去
				publishProgress(result);
				//如果AsyncTask被调用了cancel()方法，那么任务取消，跳出for循环
				if (isCancelled()) {
					break;
				}
			}
			//将总共下载的字节数作为结果返回
			return totalByte;
		}

		private Object[] downloadSingleFile(String str) {
			Object[] result = new Object[2];
			int byteCount = 0;
			HttpURLConnection conn = null;
			try {
				URL url = new URL(str);
				conn = (HttpURLConnection) url.openConnection();
				InputStream is = conn.getInputStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int length;
				while ((length = is.read(buf)) != -1) {
					byteArrayOutputStream.write(buf, 0, length);
					byteCount += length;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					conn.disconnect();
				}
			}
			result[0] = byteCount;
			result[1] = str;
			return result;
		}

		@Override
		protected void onProgressUpdate(Object... values) {
			super.onProgressUpdate(values);
			int byteCount = (int) values[0];
			String url = (String) values[1];
			String text = textView.getText().toString();
			text += "\n " + url + " 下载完成，共" + byteCount + "字节";
			textView.setText(text);
		}

		@Override
		protected void onPostExecute(Long aLong) {
			super.onPostExecute(aLong);
			String text = textView.getText().toString();
			text += "\n全部下载完成，总共下载了" + aLong + "个字节";
			textView.setText(text);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
			textView.setText("取消下载");
		}
	}
}