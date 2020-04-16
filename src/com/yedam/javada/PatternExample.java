package com.yedam.javada;

import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String reExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-2344";
		boolean result = Pattern.matches(reExp, data);
		if (result) {
			System.out.println("정규식과 일치합니다 ");
		} else {
			System.out.println("정규식과 일치하지 않습니다 ");
		}

		reExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = " angl@naver.com";
		result = Pattern.matches(reExp, data);
		if (result) {
			System.out.println("정규식과 일치합니다 ");
		} else {
			System.out.println("정규식과 일치하지 않습니다 ");
		}
	}

}
