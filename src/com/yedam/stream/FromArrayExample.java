package com.yedam.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {
	public static void main(String[] args) {
		String[] strArr = { "Hong", "Hwang", "Choi" };
		Stream<String> strStream = Arrays.stream(strArr);
		int[] intArr = { 3,4,5,6,7};
		IntStream intStream = Arrays.stream(intArr);
		
		strStream.forEach(s -> System.out.println(s));
		intStream.forEach(i -> System.out.println(i));
		
		System.out.println("----------------------------");
		IntStream rangeStream  = IntStream.range(1, 10); //1부터 9까지 출력, 10포함x
		rangeStream.forEach(r -> System.out.println(r));
		System.out.println("============================");
		IntStream rangeStream1  = IntStream.rangeClosed(1, 10); //1부터 10까지, 10포함o
		rangeStream1.forEach(r -> System.out.println(r));
		
	}
}
