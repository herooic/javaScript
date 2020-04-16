package com.yedam.io;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("머라도 써봐");
		String name= scn.nextLine();
		System.out.println("나이는 ??");
		int age = scn.nextInt();
		System.out.println("키몇?");
		double height = scn.nextDouble();
		
		System.out.print("넌 멋쟁이구나 ?");
		System.out.println(name + ", "+ age +", " + height );
		scn.close();
	}
}
