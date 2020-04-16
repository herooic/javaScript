package com.yedam.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {
   public static void main(String[] args) {
      List<Student> list = Arrays.asList(
            new Student("Hong", 10, Student.Gender.MALE),
            new Student("Hwang", 9, Student.Gender.FEMALE),
            new Student("Choi", 8, Student.Gender.MALE),
            new Student("Park", 7, Student.Gender.FEMALE)
      );
      // collect()메소드에 의해 list타입의 collect를 만듬
      // collect(Collectors.toList()) -> List<Student>
      List<Student> maleStudent = list.stream()
            .filter(s -> s.getGender() == Student.Gender.MALE) //중간처리 메소드
            .collect(Collectors.toList()); //Hong, Choi -> List
      maleStudent.stream().forEach(s -> System.out.println(s.getName()));
      
      System.out.println("-------------");
      // collect(Collectors.toSet()) -> Set<Student>
      Set<Student> femaleSet = list.stream()
            .filter(s -> s.getGender() == Student.Gender.FEMALE)
            .collect(Collectors.toSet());
      femaleSet.stream().forEach(s -> System.out.println(s.getName()));
      
      // collect(Collectors.toCollection()) -> HashSet<Student>
      // 우리가 정의하는 타입으로 만들어 주는게 toCollection()
      HashSet<Student> hashSet =
          list.stream()
         .filter(s -> s.getScore() >= 9)
         .collect(Collectors.toCollection(() -> new HashSet<Student>())); //HashSet<Student>
      
   }
}