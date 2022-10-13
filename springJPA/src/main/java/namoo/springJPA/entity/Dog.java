package namoo.springJPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString*/
@Data //위 한번에 설정  하지만 생성자는 디폴트만 만들어짐 그래서 밑에 두개 써줌 
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
	private String name;
	private int age;
	
/*	public Dog() {}

	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}*/
	
}
