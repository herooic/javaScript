package com.yedam.depart;

import java.util.List;


public class DepMain {
	public static void main(String[] args) {
		DepDAO d = new DepDAO();
		List<Department> dlist = d.getDepList();
		for (Department dep : dlist) {
			System.out.println(dep);
		}
	}

}
