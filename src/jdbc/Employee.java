package jdbc;

//import java.util.Date;

import org.springframework.stereotype.Component;
@Component(value="empl")
public class Employee {
	@Override
	public String toString() {
		return "Employee [empcode=" + empcode + ", empname=" + empname + ", job=" + job + ", salary=" + salary
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	private int empcode;
	private String empname;
	private String job;
	private double salary;
	private String dateOfBirth;
	public Employee() {
		
	}
	public Employee(int empcode, String empname, String job, double salary, String dateOfBirth) {
		super();
		this.empcode = empcode;
		this.empname = empname;
		this.job = job;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
	}
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
