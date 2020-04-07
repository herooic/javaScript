package com.yedam.lambda;

//class RunnableImpl implements Runnable {
//	@Override
//	public void run() {
//		System.out.println("runnable call");	
//	}
//}
public class BasicExpressExample {
	public static void main(String[] args) {
		
//		Runnable runnable = new RunnableImpl();
		
		Runnable runnable = new Runnable() {
			//익명객체 작성방법
			@Override 
			public void run() {
				System.out.println("runnable call");	
			}
		};
		runnable.run();
		
		
		//lambda 표현식: 필요없는 표현식을 다 뺀거
		//runnable에는 run이라는 메소트가 하나 들어있다.
		Runnable runnable1 = () ->  {
				System.out.println("runnable lambda call");	
			};
		runnable1.run();
		
		
	}//main
}//class
