package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("Context.xml");
    	Student std=ctx.getBean("std", Student.class);
    	std.setStudname("Lucky");
    	std.setStudmarks(532);
    	Address address=new Address();
    	address.setCity("Sydney");
    	address.setState("Australia");
    	std.setAddress(address);
    	System.out.println(std.getStudname()+" "+std.getStudmarks()+" "+std.getAddress().getCity()+" "+std.getAddress().getState());
    	Student std1=ctx.getBean("std", Student.class);
    	System.out.println(std1.getStudname()+" "+std1.getStudmarks()+" "+std1.getAddress().getCity()+" "+std1.getAddress().getState());
    }
}
