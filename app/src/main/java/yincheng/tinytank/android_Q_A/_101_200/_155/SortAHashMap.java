package yincheng.tinytank.android_Q_A._101_200._155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import yincheng.tinytank.provider.data.Student;

public class SortAHashMap {
	public static void main(String[] args) {
		HashMap<Integer, Student> students = new HashMap<>();
		students.put(1, new Student(25, "张三", Arrays.asList("a")));
		students.put(3, new Student(22, "李四", Arrays.asList("a")));
		students.put(2, new Student(28, "王五", Arrays.asList("a")));
		System.out.println(students);
		HashMap<Integer, Student> result = sortHashMap(students);
		System.out.println(result);
	}

	private static HashMap<Integer, Student> sortHashMap(HashMap<Integer, Student> students) {
		ArrayList<HashMap.Entry<Integer, Student>> entries = new ArrayList<>(students.entrySet());
		LinkedHashMap<Integer, Student> result = new LinkedHashMap<>();
		Collections.sort(entries, new Comparator<HashMap.Entry<Integer, Student>>() {
			@Override
			public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {
				return o2.getValue().getAge() - o1.getValue().getAge();//返回值是int
			}
		});
		for (Map.Entry<Integer, Student> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
