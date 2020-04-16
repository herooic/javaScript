package com.yedam.test;

public class Employee implements Comparable<Employee> {
   String firstName;
   int salary;

   public String getFirstName() {
      return firstName;
   }

   public int getSalary() {
      return salary;
   }

   public Employee(String firstName, int salary) {
      super();
      this.firstName = firstName;
      this.salary = salary;
   }

   @Override
   public int compareTo(Employee o) {
      return this.salary - o.salary;
   }
}