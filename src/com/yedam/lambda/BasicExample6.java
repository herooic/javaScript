package com.yedam.lambda;
//int대신 Integer로 써야함
interface Consumer<T> {
	void accept(T t);
}

class ConsumerClass<T> implements Consumer<T> {
	@Override
	public void accept(T t) {
		System.out.println(t);
	}
}

public class BasicExample6 {
	public static <T> void main(String[] args) {
		//구현클래스
		Consumer<String> c = new ConsumerClass<>();
		c.accept("HONG");
		
		//익명객체
		Consumer<String> c1 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("Hello" + t);	
			}
		};
		c1.accept("ddddd");
		
		//람다표현식
		Consumer<String> c2 = (String s) -> {
			System.out.println("Hello " + s);
		};
		c2.accept("asdfkl");
	}//main
}//class
