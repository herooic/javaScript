package com.yedam.lambda;

import java.util.Scanner;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;

public class SupplierExample { //매개값은 없는데 리턴값은 있음
	public static void main(String[] args) {
		IntSupplier intSup = () -> { //가지고 있는 메소드 이름: getAsInt()
			int num = (int) (Math.random() * 6) + 1; // 0~5까지 +1 -> 1~6
			return num;
		};
		int result = intSup.getAsInt();
		System.out.println(result);
		
		BooleanSupplier boolSup = () -> { //리턴값은 true, false
			Scanner scn = new Scanner(System.in);
			System.out.println("값을 입력하세요: ");
			int inputValue = scn.nextInt();
			int num = (int) (Math.random() * 3) + 1;
			//boolSup 재정의
			if(inputValue == num) 
				return true;
			else
				return false;
		};
		if(boolSup.getAsBoolean()) {
			System.out.println("같습니다.");
		}else {
			System.out.println("다릅니다.");
		};
	}
}
