package com.yedam.study;

public class ParentExample {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.name= "hong";
		
//		Parent에서 Child를 주석 처리함
//		Child c = new Child();
//		c.name = "Hwang";
//		c.age = 10;
//		showInfo(c);
				
		showInfo(new Parent() {
			int age;
			int getAge() {
				return age;
			}
			@Override
			String getName() {
//				return super.getName() + ", age: " + this.age;
				super.setName("Hwang");
				return super.getName();
			}
			
		});
//		Empservice empService = new EmpServiceImpl();
		EmpService empService = new EmpService() { //익명객체를 사용(Impl에 적는거랑 여기 적는거랑 같다)
			public void getEmployee(int empId) {
				System.out.println("empId: " + empId);
			}
		};
		getEmp(empService);
		getEmp(new EmpService() {
			public void getEmployee(int empId) {
				System.out.println("empId: " + empId);
			}
		});
		showInfo(new Parent());
		
//		getEmp(new EmpService() {
//			//인터페이스 객체
//			@Override
//			public void getEmployee(int empId) { //인터페이스를 재정의해주는게 들어간다.
//				System.out.println("empId: " + empId);		
//			}
//		});
		
	}
	static void getEmp(EmpService emp) {
		emp.getEmployee(101);
	}
	
	static void showInfo(Parent p) {
		System.out.println((p.getName()));
	}
}
