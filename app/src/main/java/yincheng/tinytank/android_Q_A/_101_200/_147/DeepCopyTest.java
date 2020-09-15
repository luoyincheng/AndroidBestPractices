package yincheng.tinytank.android_Q_A._101_200._147;

public class DeepCopyTest {
	public static void main(String[] args) {
		Email email = new Email("请于今天12:30到二会议室参加会议...");

		Person person1 = new Person("张三", email);

		Person person2 = person1.clone();
//		Goods person2 = DeepCopyUtil.deepCopy(person1);

		Person person3 = person1.clone();
//		Goods person3 = DeepCopyUtil.deepCopy(person1);

		person1.getEmail().setContent("请于今天12:00到二会议室参加会议...");

		System.out.println(person1.getName() + "的邮件内容是：" + person1.getEmail().getContent());
		System.out.println(person2.getName() + "的邮件内容是：" + person2.getEmail().getContent());
		System.out.println(person3.getName() + "的邮件内容是：" + person3.getEmail().getContent());

		System.out.println(person1.getName() == person2.getName());
		System.out.println(person1.getName().equals(person2.getName()));
	}

	public static class Person implements Cloneable {
		private String name;
		private Email email;

		public Person(String name, Email email) {
			this.name = name;
			this.email = email;
		}

		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Email getEmail() {
			return email;
		}

		public void setEmail(Email email) {
			this.email = email;
		}

		protected Person clone() {
			Person person = null;
			try {
				person = (Person) super.clone();
				person.setName(new String(person.getName()));
				person.setEmail(new Email(person.getEmail().getContent()));
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

			return person;
		}
	}

	public static class Email implements Cloneable {
		private String content;

		public Email(String string) {
			this.content = string;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}
