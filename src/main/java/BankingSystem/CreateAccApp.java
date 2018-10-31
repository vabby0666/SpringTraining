package BankingSystem;

import java.util.Scanner;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import jdbc.DateParsing;
@Component
public class CreateAccApp{

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);

		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotations.xml");
		AccountDao dao=ctx.getBean("accountDaoImpl", AccountDaoImpl.class);
		Account acc=ctx.getBean("account",Account.class);
		int can=dao.accnoGenerate();
		acc.setAccNo(can);
		can++;
		System.out.println("Enter your name, amount , Date , street & city to create account\n");
		acc.setCustomerName(in.next());
		acc.setBalance(in.nextDouble());
		acc.setDate(DateParsing.convertToUtilDate(in.next()));		
		int rows=dao.CreateAccount();
		if(rows>0)
			System.out.println("Account Created Sucessfully, Alloted No."+rows);
		in.close();
	}

}
