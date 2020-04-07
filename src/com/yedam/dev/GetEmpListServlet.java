package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetEmpListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append("JHI");
		EmpDAO dao = new EmpDAO();
		List<Employee> empList = dao.getEmpList();
//		밑의 모양으로 만들거임
//		[{"id":1,"first_name":"Alameda","last_name":"Bernocchi","email":"abernocchi0@alibaba.com","gender":"Female","ip_address":"62.163.33.100"},
//		{"id":2,"first_name":"Gareth","last_name":"Bennen","email":"gbennen1@canalblog.com","gender":"Male","ip_address":"122.63.201.225"},
//		{"id":3,"first_name":"Isaac","last_name":"Swannick","email":"iswannick2@scribd.com","gender"]

		//[{"empId":101,"firstName":"scott","lastName":"tiger"},] 형식 -> 마지막 ,: if(++rCnt != totalCnt) 를 통해 찍음
		String empJson = "[";
		int rCnt = 0;
		int totalCnt = empList.size();
		for (Employee e : empList) {
			empJson += "{\"empId\":" + e.getEmployeeId() + ",\"first_name\":\"" + e.getFirstName()
					+ "\",\"last_name\":\"" + e.getLastName()
					+ "\",\"email\":\"" + e.getEmail() 
					+ "\",\"salary\":" + e.getSalary() + "}";
					
			
			if(++rCnt != totalCnt) 
				empJson += ",";				
		}
		empJson += "]";
		PrintWriter out = response.getWriter();
		out.print(empJson.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
