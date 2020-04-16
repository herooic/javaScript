package com.yedam.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//application: ui를 만들수 잇음, 추상메소드
public class ServerExample extends Application {
   // 필드선언
   // Thread 관리?
   ExecutorService executorService;
   ServerSocket serverSocket;
   // 리스트에다 담기 -> 메세지를?, 접속이 생길때마다 list에 넣음
   List<Client> list = new Vector<>(); // ArrayList랑 비슷

   // 서버의 스타트, 서버환경 셋팅 thread pool 정의: executor
   void startServer() {
      System.out.println("Processor 수: " + Runtime.getRuntime().availableProcessors());
      // 4가 나오면 4개만 만들겠다.
      executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() // 갯수만큼 thread pool를
                                                                           // 만들겠다
      );
      try {
         // serverSocket도 startServer하면 실행, socket을 만들어서 주소랑 셋팅
         serverSocket = new ServerSocket();
         serverSocket.bind(new InetSocketAddress("192.168.0.69", 5001));// 5001포트
      } catch (IOException e) { // 예외처리 (IP따라갔는데 서버 없으면)
//         e.printStackTrace();
         // 연결끊는거 넣을거임, socket셋팅하다가 잘못되면 예외할거임. -> socket 연결을 끊음
         if (!serverSocket.isClosed())
            stopServer(); // serverSocket -> close()
      }
      Runnable runnable = new Runnable() {
         @Override
         public void run() {
            // runnable 실행시키는거 -> queue에다가 넣는거
            Platform.runLater(() -> {
               displayText("[서버 시작]");
               btnStartStop.setText("stop");
            });
            while (true) {
               try {
                  Socket socket = serverSocket.accept();
                  String message = "[연결 수락:] " + socket.getRemoteSocketAddress() + " : "
                        + Thread.currentThread().getName() + "]"; // currentThread 이름을 가져온다.
                  // ui 바꾸는거?
                  Platform.runLater(() -> displayText(message));
                  Client client = new Client(socket); // client에 socket값을 넣어서만듬
                  list.add(client);
               } catch (IOException e) {
//                  e.printStackTrace();
                  if (!serverSocket.isClosed()) {
                     stopServer();
                  }
                  break;
               }
            } // end of while
         } // end of run
      }; // end of runnable
         // 작업이 들어오면 하나씩 할당하겠다.
      executorService.submit(runnable);
   } // end of startServer()

   // 서버의 스탑
   void stopServer() {
      try {
         Iterator<Client> iterator = list.iterator();
         while (iterator.hasNext()) {
            Client client = iterator.next();
            client.socket.close();
            iterator.remove();// 반복자, 지우는거
         }
         if(serverSocket != null && !serverSocket.isClosed())
            serverSocket.close();
         if(executorService != null && !executorService.isShutdown()) //thread pool 종료
            executorService.shutdown();
         Platform.runLater(()-> {
        	 displayText ("[서버멈춤]");
        	 btnStartStop.setText("start");
         });
      } catch (IOException e) {
         e.printStackTrace();
      }
   } // end of stopServer()

   void displayText(String text) {
      txtDisplay.appendText(text + "\n");
   }

   // 클라이언트가 접속할때 사용
   // 메세지를 받고 보내고 하는걸 처리
   class Client {
      Socket socket;

      Client(Socket socket) {
         this.socket = socket;
         receive();
         
      }

      void receive() {
         Runnable runnable = new Runnable() {

            @Override
            public void run() {
               try {
                  while (true) {
                     InputStream is = socket.getInputStream();
                     // 100개씩 읽어서 던지도록
                     byte[] buf = new byte[100];
                     // 받아온걸 뿌려줘야함
                     int readByte = is.read(buf);
                     if (readByte == -1) {
                        throw new IOException();
                     }
                     String message = "[요청 처리: " + socket.getRemoteSocketAddress() + " : "
                           + Thread.currentThread().getName() + "]"; // 이름을 가지고 오겠다.
                     Platform.runLater(() -> {
                        displayText(message);
                     });
                     String data = new String(buf, 0, readByte, "UTF-8");
                     for (Client client : list) {
                        client.send(data);
                     }
                  } // end of while
               } catch (IOException e) {
//                  e.printStackTrace();
                  // 연결 끊는 부분
                  list.remove(Client.this);
                  String message = "[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress() + " : "
                        + Thread.currentThread().getName() + "]";
                  Platform.runLater(() -> {
                     displayText(message);
                  });
                  try {
                     socket.close();
                  } catch (IOException e1) {
                     e1.printStackTrace();
                  }
               } // end of try...catch
            } // end of run()

         }; // end of Runnable
            // 정의한 작업을 pool에 넣음
         executorService.submit(runnable);
      }

      void send(String data) {
         Runnable runnable = new Runnable() {

            @Override
            public void run() {
               byte[] buf = new byte[100];
               OutputStream os;
               try {
                  os = socket.getOutputStream();
                  buf = data.getBytes();
                  os.write(buf);
                  os.flush();
               } catch (IOException e) {
//                  e.printStackTrace();
                  String message = "[클라이언트 통신 안됨: " + Thread.currentThread().getName() + " : " + "]";
                  Platform.runLater(() -> {
                     displayText(message);
                  });
                  list.remove(Client.this);
                  try {
                     socket.close();
                  } catch (IOException e1) {
                     e1.printStackTrace();
                  }
               }
            } // end of run()
         };
         executorService.submit(runnable);
      }

   }

   public static void main(String[] args) {
      launch(args);

   }

   TextArea txtDisplay;
   Button btnStartStop;

   // UI 만드는 start()
   @Override
   public void start(Stage primaryStage) throws Exception {
      BorderPane root = new BorderPane();
      // contain만든거
      root.setPrefSize(500, 300);
      // 화면에 뿌리기 위해
      txtDisplay = new TextArea();
      // 에디트 못하게
      txtDisplay.setEditable(false);
      BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
      root.setCenter(txtDisplay);

      // 필드에다가 버튼할당해서 start라고 이름 붙임
      btnStartStop = new Button("start");
      btnStartStop.setPrefHeight(30);
      btnStartStop.setMaxWidth(Double.MAX_VALUE); // contain보다 커지지 않게
      btnStartStop.setOnAction((event) -> { // 버튼 클릭할때 이벤트
         // start면 startServer실행
         if (btnStartStop.getText().equals("start"))
            startServer();
         // stop이면 stopServer실행
         else if (btnStartStop.getText().equals("stop"))
            stopServer();
      });
      // bottom에 받음
      root.setBottom(btnStartStop);

      Scene scene = new Scene(root);
      // primaryStage에 Scene을 담
      primaryStage.setScene(scene);
      primaryStage.setTitle("Server");
      // 화면에 나타나도록 하는게 show()
      primaryStage.show();

   }

}