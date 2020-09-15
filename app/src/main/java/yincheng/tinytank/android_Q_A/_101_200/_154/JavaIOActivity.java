package yincheng.tinytank.android_Q_A._101_200._154;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import yincheng.tinytank.R;

public class JavaIOActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pathview);
		User user = new User("luoyincheng");

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/storage/emulated/0/aa.txt"));
			objectOutputStream.writeObject(user);
			objectOutputStream.close();
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/storage/emulated/0/aa.txt")));
			User user1 = (User) objectInputStream.readObject();
			System.out.println("----- " + user1.name);
			objectInputStream.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
//		try {
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("storage/emulated/0/afdfaaa.txt")));
//			objectOutputStream.writeObject(serializableObjectToFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
