package employeeTest;

import static org.junit.Assert.*;
import org.junit.Test;
//import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.impl.EmployeeDaoImpl;

public class HelloTestCase {
	EmployeeDaoImpl emp=new EmployeeDaoImpl();
	@Test
	public void test() {
		assertEquals(1,emp.deleteEmployee(124));
	}

}
