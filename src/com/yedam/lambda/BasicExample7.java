package com.yedam.lambda;

interface Consumer1<T> {
	void accept(T t);
}

class ConsumerClass1<T> implements Consumer1<T> {

	@Override
	public void accept(T t) {
		System.out.println(t);	
		}
	
}
class Students3 {
	String name;
	int age;
	Students3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	void getInfo() {
		System.out.println("이름: " + this.name + ", 나이: " + this.age);
	}
}

public class BasicExample7 {
	public static void main(String[] args) {
		//구현클래스
		Consumer1<Students3> c = new ConsumerClass1<>();
		Students3 s = new Students3("jeong", 26);
		c.accept(s);
		
		//익명객체
		Consumer1<Students3> c1 = new Consumer1<Students3>() {
			@Override
			public void accept(Students3 t) {
				t.getInfo();
			}
		};
		Students3 s1 = new Students3("Lee", 10);
		c1.accept(s1);
		
		
		//람다표현식
		Consumer1<Students3> c2 = (s2) -> {
			s2.getInfo();
		};
		Students3 s2 = new Students3("HOng", 30);
//		c2.get(new Students3("hong", 20));
		c2.accept(s2);
		
		
	}
}
