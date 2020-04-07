package com.yedam.dev;

//ctrl+shift+o
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student("Hong", "S111", 20);
		Student s2 = new Student("Hwang", "S222", 22);
		Student s3 = new Student("Park", "S333", 23);
		System.out.println("== 배열 ==");
		Student[] studAry = { s1, s2, s3 };
		for (Student s : studAry) {
			System.out.println(s.toString());
		}
		System.out.println();
		System.out.println(" == ArrayList == "); //중복가능, 순서존재
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for (Student s : list) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println(" == Set =="); //중복불가능, 순서존재x
		Set<Student> studSet = new HashSet<Student>();
		studSet.add(s1);
		studSet.add(s2);
		studSet.add(s3);
		Iterator<Student> iter = studSet.iterator(); //iter: 반복자
		while(iter.hasNext()) { //가지고올게 있는지 확인 
			System.out.println(iter.next()); //가지고올게 있으면 프린트
		}
		System.out.println();
		System.out.println(" == Map I == "); //Key,Value
		Map<Integer, Student> studMap = new HashMap<Integer, Student>();
		studMap.put(1,s1); //추가는 put
		studMap.put(2,s2);
		studMap.put(3,s3);
		Set<Integer> iSet = studMap.keySet();
		Iterator<Integer> iter2 = iSet.iterator();
		while(iter2.hasNext()) {
			Integer iKey = iter2.next();
			System.out.println("key: " + iKey 
								+ ", value: " + studMap.get(iKey).toString()); 
			//studMap.get(iKey).toString: 키에 해당하는 value를 가져온다.
			//반복자를 통해서 가져오려고
		}
		System.out.println();
		System.out.println(" == Map II == ");
		Set<Map.Entry<Integer, Student>> mSet = studMap.entrySet();
		Iterator<Map.Entry<Integer, Student>> iter3 = mSet.iterator();
		while(iter3.hasNext()) {
			Map.Entry<Integer, Student> rMap = iter3.next();
			System.out.println("key: " + rMap.getKey() 
								+ ", value: " + rMap.getValue());
		}
		
		
		
	}//main
}//class
