package aopex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopClient {
	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Annotations.xml");
		Operation oper=context.getBean("operation", Operation.class);
		oper.m();
		oper.msg();
		oper.k();
	}
}
