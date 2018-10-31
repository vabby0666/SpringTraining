package BankingSystem;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import BankingSystem.TransactionList;
@Component
public class TransactionListApp {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);

		ApplicationContext ctx=new ClassPathXmlApplicationContext("Annotations.xml");
		AccountDao dao=ctx.getBean("accountDaoImpl", AccountDaoImpl.class);
		List<TransactionList> trans=dao.ViewStatement();
		for(TransactionList tran: trans)
			System.out.println(tran.getAccNo()+" "+tran.getDate()+" "+tran.getType()+" "+tran.getDesc()+" "+tran.getAmount()+" "+tran.getBalance());
		in.close();
		if(trans.size()==0)
			System.out.println("No Data Found");
	}

}
