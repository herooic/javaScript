package com.yedam.lambda;
//교수님
@FunctionalInterface //interface안에 메소드가 하나인걸 functionalinterface라함(functionalinterface인지 확인하는 문구)
interface MyInterface2 { //get메소드 하나 있음
	void get(String str); //타켓타입
//	void set(); //메소드가 두개라서 에러가 뜬다.
}
//람다표현식은 functionalInterface일때만 사용가능

//class MyInterClass implements MyInterface2{ //구현하는 클래스 ,재정의를 할때마다 클래스를 선언해야함 -> 클래스를 익명객체로
//	@Override //재정의
//	public void get() {
//		System.out.println("Hello");
//	}
//}





public class BasicExample4 {
	public static void main(String[] args) {
//		MyInterface2 mi = new MyInterClass();
		
//		MyInterface2 mi = new MyInterface2() { //익명객체 사용방법, 정의해야할게 get밖에 없다.
//			@Override //재정의
//			public void get() {
//				System.out.println("Hello");
//			}
//		};
		
		MyInterface2 mi = (s) -> { 
			//():매개값 받는 부분, ->: 매개값을 받아서 밑에꺼를 실행해라. get메소드에 String을 정의해놔서 s앞에 String 안써도 된다
				System.out.println("Hello " + s);
		};
		mi.get("Hong");
	}
}
