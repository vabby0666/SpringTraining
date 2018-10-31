package beans;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public int addEmpl(Employee emp) {
		String sql="insert into employee values(?,?,?,?,?)";
		int rows=template.update(sql,new EmployeePSS(emp));
		return rows;
	}
		
	public List<Employee> getEmpls(){
		String sql="select * from employee";
		List<Employee> empList=template.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		return empList;
	}
}
