package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
	public static void main(String[] args) throws IOException {
		List<String> list = Arrays.asList("이현우","송아지","두루미","킹콩");
		String path = "src/com/yedam/io/input.txt";
		System.out.println(path);
		
		File fileReader = new File(path);
		FileInputStream fis = new FileInputStream("src/com/yedam/io/input.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);	
		int readByte ;
		while (( readByte = fis.read())   != -1 ) {			
		}
		fis.close();
			        
		System.out.println("쇼미");
		
		
	}
}
