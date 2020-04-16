package com.yedam.io;

import java.io.IOException;
import java.io.PrintStream;

public class SystemOutExample {
	public static void main(String[] args)throws IOException {
		PrintStream ps = System.out;
		String text = "한글은 달리 처리 해야함! 리얼";
		byte[] cbuf = text.getBytes();
		int readChar;
		ps.write(cbuf);
		ps.flush();		
	
	
	}
}
