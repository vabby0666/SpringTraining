package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmplApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotations.xml");
		//Employee emp=ctx.getBean("employee", Employee.class);
		EmployeeDao dao=ctx.getBean("employeeDao", EmployeeDao.class);
		/*dao.insert();
		System.out.println("Static Data Inserted");
		emp.setEmpcode(168);
		emp.setEmpname("hello");
		emp.setJob("job");
		emp.setSalary(4000);
		emp.setDateOfBirth(DateParsing.convertToUtilDate("12-11-2018"));
		int r=dao.addEmpl();
		System.out.println("Dynamic Data Insterted "+r);
		dao.delEmpl();
		System.out.println("Deleted Sucessfully");
		emp.setEmpcode(335);
		emp.setEmpname("hello");
		emp.setJob("job");
		emp.setSalary(4000);
		emp.setDateOfBirth(DateParsing.convertToUtilDate("12-11-2018"));
		dao.updateEmpl();
		System.out.println("Updated Sucessfully");*/
		List<Employee> empls=dao.getEmpls();
		for(Employee empl: empls)
			System.out.println(empl.getEmpcode()+" "+empl.getEmpname()+" "+empl.getJob()+" "+empl.getSalary()+" "+empl.getDateOfBirth());
		
		Employee empl=dao.getEmp(123);
		System.out.println(empl.getEmpcode()+" "+empl.getEmpname()+" "+empl.getJob()+" "+empl.getSalary()+" "+empl.getDateOfBirth()); 
		}

}
