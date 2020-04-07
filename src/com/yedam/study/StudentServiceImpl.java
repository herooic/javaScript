package com.yedam.study;

import java.util.List;

public class StudentServiceImpl implements StudentService{

	EmpDAO dao = new EmpDAO();
	
	@Override
	public List<Student> getStudList() {
		return dao.getEmpList();
	}

	@Override
	public Student getStudent(String name) {
		return dao.getEmpListInfo(name);
	}
	
	

}
