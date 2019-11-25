package yincheng.tinytank.android_Q_A.frameworks.rxjava.operators;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import yincheng.tinytank.R;
import yincheng.tinytank.provider.data.Student;

public class RxJavaConvertOperatorsActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_button);
		Student student1 = new Student(1, "1", Arrays.asList("英语", "数学", "物理"));
		Student student2 = new Student(2, "2", Arrays.asList("概率论", "大学物理", "高等数学"));
		Student student3 = new Student(3, "3", Arrays.asList("通信原理", "电磁场与电磁波", "高频"));
		List<Student> students = Arrays.asList(student1, student2, student3);
		/**
		 * Map
		 */
		Disposable mapDisposable1 = Observable
				.just(1, 2, 3, 4)
				.map(new Function<Integer, String>() {
					@Override
					public String apply(Integer integer) throws Exception {
						Log.i("RxJavaMap1", "apply:source:   " + integer);
						return Integer.toBinaryString(integer);
					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<String>() {
					@Override
					public void accept(String s) throws Exception {
						Log.i("RxJavaMap1", "accept:result:   " + s);
					}
				});

		Disposable mapDisposable2 = Observable
				.fromIterable(students)
				.map(new Function<Student, List<String>>() {
					@Override
					public List<String> apply(Student student) throws Exception {
						Log.i("RxJavaMap2", "accept:source:   " + student.getName());
						return student.getList();
					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<List<String>>() {
					@Override
					public void accept(List<String> strings) throws Exception {
						for (String string : strings) {
							Log.i("RxJavaMap2", "accept:result:   " + string);
						}
					}
				});

		/**
		 * FlatMap
		 */
		Disposable flatMapDisposable1 = Observable
				.just(1, 2, 3, 4)
				.concatMap(new Function<Integer, Observable<String>>() {
					@Override
					public Observable<String> apply(Integer integer) throws Exception {
						Log.i("RxJavaFlatMap1", "apply:source:   " + integer);
						int delay = 0;
						if (integer == 3) delay = 2000;
						return Observable.just(Integer.toBinaryString(integer)).delay(delay, TimeUnit.MILLISECONDS);
					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<String>() {
					@Override
					public void accept(String s) throws Exception {
						Log.i("RxJavaFlatMap1", "accept:result:   " + s);
					}
				});

		Disposable flatMapDisposable2 = Observable
				.fromIterable(students)
				.flatMap(new Function<Student, ObservableSource<String>>() {
					@Override
					public ObservableSource<String> apply(Student student) throws Exception {
						Log.i("RxJavaFlatMap2", "accept:source:   " + student.getName());
						return Observable.fromIterable(student.getList());
					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<String>() {
					@Override
					public void accept(String s) throws Exception {
						Log.i("RxJavaFlatMap2", "accept:result:   " + s);
					}
				});

	}
}