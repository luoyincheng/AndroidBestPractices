package yincheng.tinytank;

import androidx.annotation.NonNull;

/**
 * Created by yincheng on 2018/5/30/14:19.
 * github:luoyincheng
 */
public class Test2 {
	static final Student STUDENT = new Student(25, "luoyixiong", "foreveryoung");

	public static void main(String[] args) {
		STUDENT.age = 25;
		STUDENT.name = "luoyixiong";
		STUDENT.wishes = "being yong";
		System.out.println(STUDENT.age + "");
		System.out.println(STUDENT.name + "");
		System.out.println(STUDENT.wishes + "");
//      Student = new Student(5, "df");


		Student student1 = new Student(1, "2", "3");
		Student student2 = student1;
		student1 = new Student(2, "3", "4");
		System.out.println();
		System.out.println(student1);//2,3,4
		System.out.println(student2);//1,2,3

		int a = 4;//二进制:100
		System.out.println((a << 1) + "");//二进制:1000---------十进制:8
		System.out.println((a << 2) + "");//二进制:10000--------十进制:16
		System.out.println((a >> 1) + "");//二进制:10-----------十进制:2
		System.out.println((a >> 2) + "");//二进制:1------------十进制:1
		System.out.println((a >>= 1) + "");//赋值，相当于a = a >> 2;
		System.out.println((a) + "");

	}

	static class Student {
		int age;
		String name;
		String wishes;

		public Student(int age, String name, String wishes) {
			this.age = age;
			this.name = name;
			this.wishes = wishes;
		}

		@NonNull
		@Override
		public String toString() {
			return age + ":" + name + ":" + wishes;
		}
	}
}
