package com.yedam.depart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.dev.Employee;

public class DepDAO {
	Connection conn = null;
	
	public DepDAO() { // DB연결할때 사용.
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 라이브러리를 쓰겠다
			conn = DriverManager.getConnection(url, user, pass); // 커넥션을 사용해서 conn에 정보를 받겠다.
		} catch (ClassNotFoundException e) { // 실패했을때 강제 다운 안하고 밑에꺼 실행?
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Department> getDepList() {
		String sql = "select * from departments";
		List<Department> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { // 데이터가 있는동안 계속 처리(데이터확인: next)
				Department dep = new Department();
				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));
				list.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}
	
}
