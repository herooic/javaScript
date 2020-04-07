package com.yedam.country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.study.Student;

public class ConDAO {

Connection conn = null; //DB연결하는거
	
	public ConDAO() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "hr";
	      String passwd = "hr";
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection(url, user, passwd);
	         System.out.println("정상적으로 연결되었습니다.");

	      } catch (ClassNotFoundException | SQLException e) {
	         System.out.println("연결중 에러가 발생했습니다.");
	         e.printStackTrace();
	      }
	}
	
	public List<Country> getConList() {
	      String sql = "select * from countries";
	      List<Country> list = new ArrayList<>();
	      try {
	         PreparedStatement psmt = conn.prepareStatement(sql);
	         ResultSet rs = psmt.executeQuery();
	         while (rs.next()) {
	            Country c1 = new Country();
	            c1.setCountryId(rs.getString("country_id"));
	            c1.setCountryName(rs.getString("country_name"));
	            c1.setRegionId(rs.getInt("region_id"));
	            list.add(c1);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      return list;
	}
	
	
	
	      
}
