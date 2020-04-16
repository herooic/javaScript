package com.yedam.javada;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormantExample {
	public static void main(String[] args) {
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(sdf.format(now));
		
		sdf = new SimpleDateFormat("yyyy월  mm월 dd일");
		 System.out.println(sdf.format(now));
			
		 
		 sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss");
		 System.out.println(sdf.format(now));
		 
		 sdf = new SimpleDateFormat("오늘은 E 요일");
		 System.out.println(sdf.format(now));
		 
		 sdf = new SimpleDateFormat("올해의 D 번째 날 ");
		 System.out.println(sdf.format(now));
		 
		 sdf = new SimpleDateFormat("이달의 d 번째 날");
		 System.out.println(sdf.format(now));
		
		
	}
	
}
