package com.yedam.study;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}
//		Sample s = new Sample(); //minus는 static이 없어서 인스턴스를 만들어줘야한다. s:참조 타입

	public static void main(String[] args) {
//		EmpDAO dao = new EmpDAO();
//		List<Student> list = dao.getEmpList();
//		for(Student s : list) {
//			System.out.println(s);
//		}
		StudentService service = new StudentServiceImpl(); 
		//인터페이스는 인스턴스를 못만든다., impl:구현, service:정의(open Declaration 클릭하면 어디서 구현되는지 볼수있음)
		List<Student> list = service.getStudList();
		for(Student s : list) {
			System.out.println(s.toString());
		}
		
//		service.getStudent(10);
		
		System.out.println("----------------------------------------");
		Student sd = service.getStudent("Steven");
		System.out.println(sd);
		
		
//		Board bod = b.getBoardInfo(1);
//		System.out.println(bod);
		
//		System.out.println("---------------------------------");
//		Person p1 = new Person();
//		p1.setName("Hong");
//		p1.setAge(10);
//		String n = p1.getName();
//		int a = p1.getAge();
//		Person p2 = new Person("Hwang", 20);
////		System.out.println(p2.getName() + " " + p2.getAge());
//
//		Student s1 = new Student();
//		s1.setName("Park");
//		s1.setAge(20);
//		s1.setSchool("yedam");
////		System.out.println(s1);
//		Student s2 = new Student("Kim", 10, "yedam");
//
//		Person[] persons = new Person[5];
//		persons[0] = p1;
//		persons[1] = s1;
//		persons[2] = new Student();
//		persons[3] = new Person("Lee", 25);
//		persons[4] = new Person();
//		String searchName = "Park";
//		for (Person p : persons) {
//			if (p.getName() != null && p.getName().equals(searchName))
//				System.out.println("찾을이름: " + searchName + "-> 결과: " + p);
//		}
//		System.out.println("-------------------------------------------------");
		
//		List<Person> list = new ArrayList<>();
//		list.add(p1);
//		list.add(p2);
//		list.add(s1);
//		list.add(s2);
//		list.remove(1); // 인덱스 값이 1인 p2를 제거
//		if(list.remove(p2)) { //p2가 삭제되면서 sout을 출력한다.
//			System.out.println("삭제되었습니다.");
//		}
//		for (Person p11 : list) {
//			System.out.println(p11.toString());
//		}
	}
}
