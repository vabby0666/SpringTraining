package com.medplus.employees.application;

import java.util.List;
import java.util.Scanner;

import com.medplus.employees.Dao.employeeDao;
import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.impl.EmployeeDaoImpl;
import com.medplus.employees.utils.DateParsing;

public class AddEmployee {
	public static void main(String args[])
	{
		Employee emp=new Employee();
		Scanner in=new Scanner(System.in);
		
		int f;
		do {
			System.out.println("Enter 1: add employee, 2: delete employee, 3: update employee details,4:Get Employee Details,5:Get All Employee Details 0:Exit\n");
			f=in.nextInt();
			if(f==1)
			{
				System.out.println("Enter Employee code, name, job role, salary, date of birth(format: dd-mm-yyy) respectively\n");

				emp.setEmpcode(in.nextInt());
				emp.setEmpname(in.next());
				emp.setJob(in.next());
				emp.setSalary(in.nextDouble());
				emp.setDateOfBirth(DateParsing.convertToUtilDate(in.next()));
				employeeDao dao=new EmployeeDaoImpl();
				int rows=dao.addEmployee(emp);
				if(rows>0)
					System.out.println("Inserted");
				else
					System.out.println("not Inserted");
			}
			else if(f==2)
			{
				System.out.println("Enter Employee code to delete their details");
				employeeDao dao=new EmployeeDaoImpl();
				int rows=dao.deleteEmployee(in.nextInt());
				if(rows>0)
					System.out.println("Deleted");
				else
					System.out.println("not Deleted");
			}
			else if(f==3)
			{
				System.out.println("Enter Employee code to change following details name, job role, salary, date of birth(format: dd-mm-yyy) respectively\n");

				emp.setEmpcode(in.nextInt());
				emp.setEmpname(in.next());
				emp.setJob(in.next());
				emp.setSalary(in.nextDouble());
				emp.setDateOfBirth(DateParsing.convertToUtilDate(in.next()));
				employeeDao dao=new EmployeeDaoImpl();
				int rows=dao.updateEmployee(emp);
				if(rows>0)
					System.out.println("Modified");
				else
					System.out.println("not Modified");
			}
			else if(f==4)
			{
				System.out.println("Enter Employee code to get their details");
				employeeDao dao=new EmployeeDaoImpl();
				Employee rows=dao.getEmployee(in.nextInt());
				System.out.println(rows);
			}
			else if(f==5)
			{
				System.out.println("All Employee Details\n");
				employeeDao dao=new EmployeeDaoImpl();
				List<Employee> rows=dao.getEmpls();
				System.out.println(rows);
			}
		}while(f!=0);
		in.close();	
	}
}
