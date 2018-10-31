package annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import annotations.Student;

public class Application {
	public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotations.xml");
		Student std=ctx.getBean("student", Student.class);
    	System.out.println(std.getStdavg()+" "+std.getStdname()+" "+std.getStdcode()+" "+std.getMarks().getTotal()+" "+std.getMarks().getGrade());
    }
}