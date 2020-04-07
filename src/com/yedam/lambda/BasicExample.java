package com.yedam.lambda;

import java.awt.Toolkit;

//구현클래스
class RunnableCls implements Runnable {
	@Override
	public void run() {
		Toolkit tkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 10; i++) {
			tkit.beep(); // 소리를 내는거(띵~)
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BasicExample {
	public static void main(String[] args) {
		Runnable rc = new Runnable() { //익명객체를 만듬
			public void run() {
				Toolkit tkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 10; i++) {
					tkit.beep(); // 소리를 내는거(띵~)
					System.out.println("beep()");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				};
				
			
//		Toolkit tkit = Toolkit.getDefaultToolkit();
//		RunnableCls rcs = new RunnableCls(); //신규작업 인스턴스
//		Thread thread = new Thread(); //쓰레드 생성
//		thread.start(); //신규작업 시작
		
		// 띵 10번이 끝나면 10번 화면에 찍힌다.
//		for (int i = 0; i < 10; i++) {
//			tkit.beep(); // 소리를 내는거(띵~)
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//
//				e.printStackTrace();
//			}
//		}

		for (int i = 0; i < 10; i++) {
			System.out.println("print it -> " + i); // 화면에 찍는거
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	}
}
}
