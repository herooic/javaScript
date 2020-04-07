package com.yedam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

class Student {
	//필드
	private String name;
	private String sex;
	private int englishScore;
	private int mathScore;
	
	public Student() {	}
	//생성자
	Student(String name, String sex, int englishScore, int mathScore) {
		this.name = name;
		this.sex = sex;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	//get 메소드
	String getName() {return name;}
	int getEnglishScore() {return englishScore;}
	int getMathScore() { return mathScore;}
	public String getSex() {
		return sex;
	}
	
}

public class FunctionExample1 {
	private static List<Student> list = Arrays.asList(
//			list.add(new Student("홍길동", 90, 96));
//			list.add(new Student("신용권", 95, 93));
			new Student("홍길동", "M", 90, 96),
			new Student("신용권", "M", 95, 93)
			);
	
	public static void printString(Function<Student, String> function) {
//		for(Student student : list) {
//		String str = function.apply(new Student());
//		System.out.println("반환값: " + str);
//		}
		for(Student student : list) {
			System.out.println(student);
			System.out.println(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	public static void printInt( ToIntFunction<Student> function) {
		for(Student student : list) {
			System.out.print(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	public static double avg(ToIntFunction<Student> func) {
		double avg = 0;
		int sum = 0;
		for(Student student :list) {
			sum += func.applyAsInt(student);
		}
		avg = (double) sum / list.size();
		return avg;
	}
	
	public static void main(String[] args) {
		//익명객체
//		printString(new Function<Student, String>() {
//			@Override
//			public String apply(Student t) {
//				return t.getName();
//			}
//		});
		
		System.out.println("[학생 이름]");
		printString( t -> t.getName());
		
		System.out.println("[영어 점수]");
		printInt( t -> t.getEnglishScore());
//		printInt((t) -> {
//			return t.getEnglishScore(); //int
//		});
		
		System.out.println("[수학 점수]");
		printInt( t -> t.getMathScore());
		
		
		
		//익명객체
		Function<Student, String> fn = new Function<Student, String>() {
			@Override
			public String apply(Student t) {
				return t.getName(); //반환값: String타입
			}
		};
		printString(fn); //홍길동 신용권 나옴
		
		
		//람다표현식
		printString((t) -> { 
			return t.getName();//홍길동 신용권 나옴
		});
		
		
		double avg = avg(s -> s.getEnglishScore());
		System.out.println("영어평균: " + avg);
		
//		avg = avg(s-> s.getMathScore());
		
		avg = avg(new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student t) {
				return t.getMathScore();
			}		
		});
		System.out.println("수학평균: " + avg);
	}
}

