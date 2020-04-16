package io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CellPhone {
	static String fileName = "원수리스트.txt";
	static class Address {
		String name;
		String age;
		String phone;
		public Address(String name, String age, String phone) {
			super();
			this.name = name;
			this.age = age;
			this.phone = phone;	
	}
}
	static Scanner scn= new Scanner(System.in);	
	public static void main(String[] args) {
		String meun = "";
		System.out.println("========================");
		System.out.println(" 원수 데스노트작성 ");
		System.out.println("------------------------");
		System.out.println("이름입력 :");
		String name = scn.nextLine();
		System.out.println("나이 : ");
		String age = scn.nextLine();
		System.out.println("처치할  날짜  :");
		String phone = scn.nextLine();
		
		Address addr = new Address(name, age, phone);			
		try {
			FileWriter fw = new FileWriter(fileName, true);
			fw.write("\n " + addr.name + ","+ addr.age +","+ addr.phone+ "\n");
			fw.flush();			
			fw.close();
			
			} catch (IOException e) {		
				e.printStackTrace();
			}
		System.out.println("-------------------------");
			System.out.println("작성완료");
	}
}