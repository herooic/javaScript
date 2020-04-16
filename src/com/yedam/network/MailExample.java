package com.yedam.network;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailExample {
   public static void main(String[] args) throws AddressException, MessagingException {
      String host = "smtp.naver.com"; // Mail서버
      final String user = "herooic@naver.com"; // ID
      final String passwd = "znlfl5016!@"; // 비밀번호

      String toUser1 = "herooic@naver.com"; // 수신 메일주소
      String toUser2 = "xxgy9796@naver.com";
      
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.naver.com");
      props.put("mail.smtp.port", 587);
      props.put("mail.smtp.auth", true);
      props.put("mail.smtp.ssl.enable", "true");
      props.put("mail.smtp.ssl.trust", "smtp.naver.com");

  

      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, passwd);
         }
      });
      
     
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(user));
     
      
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(toUser1, toUser2));

      message.setSubject("예담 금융 "); // 메일 제목
      message.setText("해킹당하셨습니다"); // 메일 본문
      Transport.send(message); // 메일 발송
      System.out.println("메일 전송됨");
      
   
   }
}



