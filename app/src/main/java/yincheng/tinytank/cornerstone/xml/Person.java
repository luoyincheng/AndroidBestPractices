package yincheng.tinytank.cornerstone.xml;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:06:09 13:41
 * Github : yincheng.luo
 */
public class Person {
	Integer id;
	String name;
	Short age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}