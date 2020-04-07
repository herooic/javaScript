package com.yedam.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	Connection conn = null;
	
	public BoardDAO() {
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
//	전체 조회
	public List<Board> getBoardList() {
		String sql = "select board_no, content, writer, create_date from board\r\n" 
					+ "order by board_no asc"; //desc: 내림차순, asc: 오름차순
		List<Board> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board bod = new Board();
				bod.setBoardNo(rs.getInt("board_no"));
				bod.setContent(rs.getString("content"));
				bod.setWriter(rs.getString("writer"));
				bod.setDate(rs.getString("create_date"));
				list.add(bod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
//	한건조회
	public Board getBoardInfo(int boardNo) {
		String sql = "select board_no, content, writer, create_date from board\r\n" + 
				"where board_no = ? \r\n";
		Board bod = new Board();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery(); //executeQuery(): 결과값이 rs에 담긴다.
			if(rs.next()) { //있으면 가지고 오고 없으면 안가지고 옴
				bod.setBoardNo(rs.getInt("board_no"));
				bod.setContent(rs.getString("content"));
				bod.setWriter(rs.getString("writer"));
				bod.setDate(rs.getString("create_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bod;
	}
	
//	추가
	public void insertBoard(Board bod) {
		String sql = "insert into board \r\n" + 
				"values( (select nvl(max(board_no),0)+1 from board)\r\n" +
				" , ? -- 글내용\r\n" + 
				" , ?  -- 작성자\r\n" + 
				" , sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bod.getContent());
			pstmt.setString(2, bod.getWriter());
			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	
	
	
}//class
