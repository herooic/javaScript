package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
	private String firstName;
	private int salary;

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", salary=" + salary + "]";
	}

	public Employee(String firstName, int salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
public class ScannerExample {
	static List<Employee> list = new ArrayList<>();

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void inputEmp(Employee emp) {
		Connection con = getConnection();
		String sql = "INSERT INTO emps VALUES (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setInt(2, emp.getSalary());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Employee> getEmpList() {
		Connection con = getConnection();
		String sql = "select first_name, salary from emps";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getString("first_name"), rs.getInt("salary")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
//		System.out.println(list);
		return list;
	}

	   public static void delEmp(String name, int salary) {
		      Connection con = getConnection();
		      String sql = "DELETE FROM emps WHERE first_name = ? and salary = ?";
	    
		      try {
		         PreparedStatement pstmt1 = con.prepareStatement(sql);
		         pstmt1 = con.prepareStatement(sql);
		         pstmt1.setString(1, name);  
		         pstmt1.setInt(2, salary);
		         int result = pstmt1.executeUpdate();
		         System.out.println(result +"건 삭제완료");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	     
		      try {
		        con.close();
		      
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }
	
	public static void main(String[] args) {
		Employee emp = new Employee("Hwang", 1000);
		list.add(emp);
		list.add(new Employee("Hwang", 2000));

		Scanner scn = new Scanner(System.in);
		int menu;
		while (true) {
			System.out.println("1:입력 \\ 2:출력 \\ 3:삭제(이름)\\ 4:종료\\");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("이름입력: ");
				String name = scn.nextLine();
				System.out.println("연봉입력: ");
				int salary = scn.nextInt();
				Employee emps = new Employee(name, salary);
				inputEmp(emps);
			} else if (menu == 2) {
				List<Employee> returnList = getEmpList();
				for (Employee emps : returnList) {
				System.out.println(emps);
				}
			} else if (menu == 3) {
			    System.out.println("삭제할 이름을 입력해주십시오.");
			    String name = scn.nextLine();
			    System.out.println("삭제할 급여을 입력해주십시오.");
			    int salary = scn.nextInt();
			    delEmp(name, salary);			    		    
			}else if (menu == 4) {				
			
				break;
				}
			}
		}
	   }
	
