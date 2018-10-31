package jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDao extends JdbcDaoSupport {
	@Autowired
	Employee emp;
	@Autowired
	EmployeePSS pss;
	@Autowired
	EmployeePSSUpd pssd;
	@Autowired
	public EmployeeDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	public void insert() {
		String sql="insert into employee values(333,'xyz','dev',6000,'2016-07-11')";
		getJdbcTemplate().execute(sql);
	}
	public int addEmpl() {
		String sql="insert into employee values(?,?,?,?,?)";
		/*Object[] args= {emp.getEmpcode(),emp.getEmpname(),emp.getJob(),emp.getSalary(),emp.getDateOfBirth()};
		int rows=getJdbcTemplate().update(sql, args);*/
		int rows=getJdbcTemplate().update(sql, pss);
		return rows;
	}
	public void delEmpl() {
		String sql="delete from employee where empcode=334";
		getJdbcTemplate().execute(sql);
		
	}
	public int updateEmpl() {
		String sql="update employee set empname=?,job=?,salary=?,dateofbirth=? where empcode=?";
		int rows=getJdbcTemplate().update(sql, pssd);
		return rows;
	}
	
	public List<Employee> getEmpls(){
		String sql="select * from employee";
		List<Employee> empList=getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		return empList;
	}
	public Employee getEmp(int code) {
		String sql="select * from employee where empcode=?";
		Object[] args= {code};
		Employee emp=getJdbcTemplate().queryForObject(sql, args, new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}
	
}
