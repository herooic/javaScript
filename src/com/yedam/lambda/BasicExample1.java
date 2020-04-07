package com.yedam.lambda;

import java.awt.Toolkit;

//1. 구현클래스
class RunnableCls1 implements Runnable {
   @Override
   public void run() {
      Toolkit tkit = Toolkit.getDefaultToolkit();
      for (int i = 0; i < 10; i++) {
         tkit.beep();
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

public class BasicExample1 {
   public static void main(String[] args) {
      RunnableCls1 rcs = new RunnableCls1();
      Thread thread = new Thread(rcs);
      thread.start();
      for (int i = 0; i < 10; i++) {
         System.out.println("print it. = >" + i);
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
