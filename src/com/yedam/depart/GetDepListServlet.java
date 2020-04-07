package com.yedam.depart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/GetDepListServlet")
public class GetDepListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetDepListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		DepDAO dao = new DepDAO();
		for (Department d : dao.getDepList()) {
			obj.put("department_id", d.getDepartmentId());
			obj.put("department_name", d.getDepartmentName());
			obj.put("manager_id", d.getManagerId());
			obj.put("location_id", d.getLocationId());
			ary.add(obj);
		}
		PrintWriter out = response.getWriter();
		out.print(ary.toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
