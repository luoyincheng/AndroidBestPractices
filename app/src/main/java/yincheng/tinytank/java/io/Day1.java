package yincheng.tinytank.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import yincheng.tinytank.provider.data.Student;

public class Day1 {
	public static void main(String[] args) {
		Student student1 = new Student(1, "1", Arrays.asList("a"));
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/home/yincheng/Desktop/outputstreamtest"));
			objectOutputStream.writeObject(student1);
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/home/yincheng/Desktop/outputstreamtest"));
			Student student = (Student) objectInputStream.readObject();
			objectInputStream.close();
			System.out.println(student.getAge() + "：" + student.getName());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
