package com.yedam.lambda;

@FunctionalInterface 
interface MyInterface3 { 
	String get(String str, String str1);
}

class Students {
	String name;
	int age;
}
@FunctionalInterface 
interface MyInterface4<T> {
	void get(T t); //제너릭이 아니라고 object이면 쓸때마다 행변환이 필요하다.
}

public class BasicExample5 {
	public static void main(String[] args) {
		MyInterface3 mi = new MyInterface3() {
			@Override
			public String get(String str, String str1) {
				return str.concat(str1); //str + str1
			}
		};
		String result = mi.get("Hello ", "World");
		System.out.println(result);
		
		MyInterface4<Students> mi1 = (Students s1) -> {
			System.out.println("Hello " + s1);
		};
		mi1.get(new Students()); //인스턴스 만들어서 넣어야 할듯
	}

}
