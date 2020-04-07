package com.yedam.study;

public class Person {
	private String name; //메소드에 직접 접근못하게 하려고
	private int age;
	

	//생성자
	public Person() {
		super();
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	//get,set 메소드
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
