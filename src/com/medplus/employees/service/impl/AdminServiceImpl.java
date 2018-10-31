package com.medplus.employees.service.impl;

import java.util.List;

import com.medplus.employees.Dao.employeeDao;
import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.impl.EmployeeDaoImpl;
import com.medplus.employees.service.AdminService;

public class AdminServiceImpl implements AdminService{
	employeeDao dao=new EmployeeDaoImpl();
	
	@Override
	public int AddEmployee(Employee employee) {
		int rows=0;
		rows=dao.AddEmployee(employee);
		return rows;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int rows=0;
		rows=dao.updateEmployee(employee);
		return rows;
	}

	@Override
	public int deleteEmployee(int empcode) {
		// TODO Auto-generated method stub
		int rows=0;
		rows=dao.deleteEmployee(empcode);
		return rows;
	}

	@Override
	public Employee getEmployee(int empcode) {
		Employee emp=dao.getEmployee(empcode);
		return emp;
	}

	@Override
	public List<Employee> getEmpls() {
		List<Employee> employees=dao.getEmpls();
		return employees;
	}
}