package com.yedam.lambda;

interface MyInterface {
	void method(int a); //리턴값이 없음
}

interface MyInterfaceReturn {
	int getResult(int a, int b); //리턴값은 int
}

public class BasicExpressExample2 {
	public static void main(String[] args) {
		
		MyInterface mi = (num) -> {
			System.out.println("method call "  + num);
		};
		mi.method(10);
		
		MyInterfaceReturn mir = new MyInterfaceReturn() {
			
			@Override
			public int getResult(int a, int b) {
				return a + b; //재정의 해야함
			}
		};
		//매번 변수를? 선언 안해줘도 된다
		//람다표현식
		mir = (num1, num2) -> {
			return num1 * num2;
		};
		
		int result = mir.getResult(10, 20);
		
		System.out.println("result: " + result);
	}
}
