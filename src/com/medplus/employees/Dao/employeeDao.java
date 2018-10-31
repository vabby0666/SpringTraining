package com.medplus.employees.Dao;

import java.util.List;

import com.medplus.employees.beans.Employee;

public interface employeeDao {
 
	public int AddEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(int empcode);
	Employee getEmployee(int empcode);
	List<Employee> getEmpls();
 public void openDBconnection();
 public void close();
}
