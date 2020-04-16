package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class LambdaExpressionExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong", 90), 
				new Student("Hwang", 92)
				);
//		Stream<Student> stream = list.stream(); 
//		중간처리, 최종처리로 나눠진다.
		list.stream().forEach(s ->  { //forEach: 최종처리
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + ", "+ score);
		});
	}
}
