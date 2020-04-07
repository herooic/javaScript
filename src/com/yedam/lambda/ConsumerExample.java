package com.yedam.lambda;

import java.util.function.BiConsumer;


public class ConsumerExample {
	public static void main(String[] args) {
//		BiConsumer<T,U> -> accept(T t, U u)
//		BiConsumer<Students3, String> biCon = (Students3 std, String str) ->
//		std.getInfo(); //안녕하세요. 이름:?? 나이:??
//		System.out.println(str);
		
//		BiConsumer<Students3, String> biCon = null; 초기화, 안해주면 오류가 뜬다.
//		printAccept(biCon, s1, s2);
		
		
		BiConsumer<Students3, String> biCon = (s1, s2) -> {
		System.out.print(s2 + " ");
		s1.getInfo();
		};
//			(std, str) -> {
//			System.out.println(str + " ");
//			std.getInfo(); //안녕하세요. 이름:?? 나이:??
//		};
		Students3 s1 = new Students3("Hwang", 20);
		String s2 = "안녕하세요";
//		biCon.accept(s1,s2); //실제값이 들어가는거
		printAccept(biCon, s1, s2);
	
		BiConsumer<String, String> biStr = (str1, str2) -> {
			System.out.println(str1 + " " + str2);
		};
		biStr.accept("람다는", " 그지같아");
		
	}
	
	
//	메소드로 사용가능.
	//앞쪽 <T,U> 제너릭 타입이라고 알려줌
	static <T,U> void printAccept(BiConsumer<Students3,String> biCon, 
									Students3 std, String str) {
		
//		biCon = (s1, s2) -> {
//			System.out.println(s2 + " ");
//			s1.getInfo();
//		};
		biCon.accept(std, str);
	}
	
}
