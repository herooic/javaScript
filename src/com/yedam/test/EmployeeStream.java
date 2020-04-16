package com.yedam.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import com.yedam.config.PropertiesExample;

public class EmployeeStream {
   public static void main(String[] args) throws FileNotFoundException, IOException {
	  String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "hr";
      String pass = "hr";
      Connection conn = null;
      
      System.out.println("url: " + url +"\nuser: " + user + "\npass: " + pass);
      System.out.println("==============사원/급여==============");
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, pass);
      } catch (ClassNotFoundException e) {
    	  e.printStackTrace();
      } catch (SQLException e) { 
    	  e.printStackTrace();
      }
      List<Employee> list = new ArrayList<>();
      
      try{
         PreparedStatement pstmt = conn.prepareStatement("select first_name, salary from employees");
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            list.add(new Employee(rs.getString("first_name"), rs.getInt("salary")));
         }
      }catch(SQLException e) {
      System.out.println();
      }
      Stream<Employee> stream = list.stream();
   
      stream.forEach( (s) -> System.out.println(s.getFirstName()
            + ", " + s.getSalary()));
   }
}