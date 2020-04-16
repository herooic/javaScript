package com.yedam.javada;

import java.text.MessageFormat;

public class MessageFormatExample {
	public static void main(String[] args) {
		String id = "java";
		String name = "신용권";
		String tel = "010-123-1234";
		
		String text = "회원 Id : {0} \n 회원이름 : {1} \n 회원 전화 {2}";
		String result1 = MessageFormat.format(text,id,name,tel);
		System.out.println(result1);
		System.out.println();
		
		String sql = "insert into member values({0}, {1}, {2})";
		Object[] arguments = {"'java'", "'신용권'","'012-123-4132'"};
		String result2 = MessageFormat.format(sql , arguments);
		System.out.println(result2 );
		
		
	}
}
