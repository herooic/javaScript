package com.yedam.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertEmpServlet")
public class InsertEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertEmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String jobId = request.getParameter("jobId"); 
		//xhtp.send("lastname=" + lName + "&email=" + email + "&jobId=" + jobId);
		//field1=value1$field2=value2$field3=value3
		//field의 value를 가지고 와서 string lastname에 넣는다.
		//send의 "" 안의거랑 request.getParameter("jobId"); "" 안의거랑 같아야함.
		System.out.println("lastname: " + lastname + ", email: " + email + ", jobId: " + jobId);
		
		//데이터베이스 입력처리
		Employee emp = new Employee();
		emp.setLastName(lastname);
		emp.setEmail(email);
		emp.setJobId(jobId);
		
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(emp);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
