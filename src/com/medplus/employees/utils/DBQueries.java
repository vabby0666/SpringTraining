package com.medplus.employees.utils;

public class DBQueries {

	public static String addempl="insert into employee values(?,?,?,?,?)";
    public static String delempl="delete from employee where empcode=?";
    public static String updempl="update employee set empname=?,job=?,salary=?,dateofbirth=? where empcode=?";
	public static String getempl="select empcode,empname,job,salary,dateofbirth from employee where empcode=?";
	public static String getempls="select empcode,empname,job,salary,dateofbirth from employee";

}
