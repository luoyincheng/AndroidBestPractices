package yincheng.tinytank.android_Q_A._101_200._146;

public class TransformationTest {
	public static void main(String[] args) {
		ChildClass childClass = new ChildClass("a", "b", "c");
		afterNodeRemoval(childClass);//child可以作为parent传入
	}

	private static void afterNodeRemoval(ParentClass parentClass) {
		System.out.println(((ChildClass) parentClass).after);
	}
}
