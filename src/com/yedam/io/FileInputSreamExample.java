package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputSreamExample {
	public static void main(String[] args)  throws IOException {
		String path = "src/com/yedam/io/input.txt";
		FileInputStream fis = new FileInputStream(path);
		String outPath = "src/com/yedam/io/output.txt";
		FileOutputStream fos = new FileOutputStream(outPath);
		int readByte2;
		while((readByte2 = fis.read()) != -1 ) {
			fos.write(readByte2);
			
			System.out.print((char)readByte2);
		}
		fis.close();
		fos.flush();
		fos.close();
	}
}
