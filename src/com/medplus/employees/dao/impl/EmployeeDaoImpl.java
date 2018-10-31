package com.medplus.employees.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.employees.Dao.employeeDao;
import com.medplus.employees.beans.Employee;
import com.medplus.employees.utils.DBQueries;
import com.medplus.employees.utils.DateParsing;
import com.mysql.jdbc.Driver;

public class EmployeeDaoImpl implements employeeDao {

	Connection conn=null;
	PreparedStatement pst;
	ResultSet rs;
	
	@Override
	public int AddEmployee(Employee employee) {
		int rows=0;
		openDBconnection();
		try {
		pst=conn.prepareStatement(DBQueries.addempl);
		pst.setInt(1, employee.getEmpcode());
		pst.setString(2, employee.getEmpname());
		pst.setString(3, employee.getJob());
		pst.setDouble(4, employee.getSalary());
		pst.setDate(5, DateParsing.ConvertToSqlDate(employee.getDateOfBirth()));
		rows=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return rows;
	}


	@Override
	public void openDBconnection() {
		String url="jdbc:mysql://localhost:3306/employee";
		String user="root";
		String pass="root";
		try {
			DriverManager.registerDriver(new Driver());
			conn=DriverManager.getConnection(url, user, pass);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}


	@Override
	public int updateEmployee(Employee employee) {
		int rows=0;
		openDBconnection();
		try {
		pst=conn.prepareStatement(DBQueries.updempl);
		pst.setInt(5, employee.getEmpcode());
		pst.setString(1, employee.getEmpname());
		pst.setString(2, employee.getJob());
		pst.setDouble(3, employee.getSalary());
		pst.setDate(4, DateParsing.ConvertToSqlDate(employee.getDateOfBirth()));
		rows=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return rows;
	}


	@Override
	public int deleteEmployee(int empcode) {
		int rows=0;
		openDBconnection();
		try {
		pst=conn.prepareStatement(DBQueries.delempl);
		pst.setInt(1, empcode);
		rows=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return rows;
	}


	@Override
	public Employee getEmployee(int empcode) {
		Employee emp=new Employee();
		openDBconnection();
		try {
		pst=conn.prepareStatement(DBQueries.getempl);
		pst.setInt(1,empcode);
		rs=pst.executeQuery();
		if(rs.next()) {
		emp.setEmpcode(rs.getInt(1));
		emp.setEmpname(rs.getString(2));
		emp.setJob(rs.getString(3));
		emp.setSalary(rs.getDouble(4));
		emp.setDateOfBirth(rs.getDate(5));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return emp;
	}


	@Override
	public List<Employee> getEmpls() {
		openDBconnection();
		List<Employee> est=new ArrayList<>();
		try {
			pst=conn.prepareStatement(DBQueries.getempls);
			rs=pst.executeQuery();
			while(rs.next())
			{
				est.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return est;
	}


	
	
}
