package com.yedam.dev;

public class Student {
	String sName;
	String sNo;
	int age;
	
	//Generate Constructor using Fields: 생성
	public Student(String sName, String sNo, int age) {
		super();
		this.sName = sName;
		this.sNo = sNo;
		this.age = age;
	}

	//Generate Getters and Setters 
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//Generate toString()
	@Override
	public String toString() {
		return "Student [sName=" + sName + ", sNo=" + sNo + ", age=" + age + "]";
	}
	
	
}
