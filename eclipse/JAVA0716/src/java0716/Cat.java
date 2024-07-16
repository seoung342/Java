package java0716;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@ToString

public class Cat {
	private String breed; // 품종
	private String color; // 색
	private int age;	  // 나이
	
	
//	Cat(){
//		System.out.println("Cat()");
//	}	// 기본 생성자
//	
//	Cat(int age){	// 생성자
//		this("삼색","검은색",age);
//	}
//
//	public Cat(String breed, String color, int age) {
//		this.breed = breed;
//		this.color = color;
//		if(age > 9) {
//			this.age = age;
//		}
//	}
}
