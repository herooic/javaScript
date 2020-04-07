package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong", 90), 
				new Student("Hwang", 92),
				new Student("Park", 72)
				);
		//중간처리 단계: mapToInt, average를 통해
		double avg = list.stream() //Student타입
				.mapToInt(s -> s.getScore())//중간처리 단계, ToIntFunction
//				return(s.getScore();)
				.average() //중간처리
				.getAsDouble(); //최종처리, 리턴타입: int, double, String이 아닌거.
		
		Stream<Student> stream = list.stream();
		IntStream intStream = stream.mapToInt((Student s) -> { //mapper 부분에 람다 표현식으로
			return s.getScore();
		});
		OptionalDouble odbl = intStream.average();
		avg = odbl.getAsDouble();
		
		System.out.println(avg);
	}
}
