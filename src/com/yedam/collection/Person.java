package com.yedam.collection;

public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	
//	나이순으로
	public int compareTo(Person o) {
//		return this.age - o.age;
		if(this.age > o.age) {
			return 1;
		}else if ( this.age < o.age) {
			return -1;
		}else {
			return 0;
		}
	}

//	이름순으로
//	public int compareTo(Person o) {
////		return this.age - o.age;
//		return this.name.compareTo(o.name);
//
//	}
}
