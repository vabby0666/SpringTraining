package beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class EmployeePSS implements PreparedStatementSetter {
	
	Employee emp;
	public EmployeePSS(Employee emp) {
		this.emp=emp;
	}
	
	public EmployeePSS() {
		super();
	}

	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(1, emp.getEmpcode());
		pst.setString(2, emp.getEmpname());
		pst.setString(3, emp.getJob());
		pst.setDouble(4, emp.getSalary());
		pst.setDate(5, DateParsing.convertDate(emp.getDateOfBirth()));
	}
}
