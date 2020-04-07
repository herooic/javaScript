package com.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dev.EmpDAO;
import com.yedam.dev.Employee;


@WebServlet("/GetBoardListServlet")
public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetBoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		BoardDAO dao = new BoardDAO();
		List<Board> bList = dao.getBoardList();
		String bodJson = "[ \r\n";
		int rCnt = 0;
		int totalCnt = bList.size();
		for (Board b : bList) {
			bodJson += "{\"boardNo\":" + b.getBoardNo() + ",\"content\":\"" + b.getContent()
					+ "\",\"writer\":\"" + b.getWriter()
					+ "\",\"date\":\"" + b.getDate() + "\"}";
			
			if(++rCnt != totalCnt)
				bodJson += ", \r\n";
		}
		bodJson += "\r\n]";
		PrintWriter out = response.getWriter();
		out.print(bodJson.toString());
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
