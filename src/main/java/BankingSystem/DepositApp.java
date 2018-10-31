package BankingSystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DepositApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotations.xml");
		AccountDao dao=ctx.getBean("accountDaoImpl", AccountDaoImpl.class);
		int rows=dao.Deposit();
		if(rows>0)
		{
			System.out.println("Deposit Sucessful available balance: "+rows);
		}
	}

}
