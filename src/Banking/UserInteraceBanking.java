package Banking;
import java.util.Scanner;
public class UserInteraceBanking extends Banking {
	
	public static void main(String args[])
	{
		UserInteraceBanking bank=new UserInteraceBanking();
		Scanner in=new Scanner(System.in);
		String opt = null;
		int ac1;
		double amo1;
		String name1;
		while(opt!="x")
		{
			System.out.println("Choose one option\nC:Create Account\nD:Deposit\nW:Withdraw\nB:Check Balance\nX:exit\nL:List");
			opt=in.next();
			switch(opt)
			{
			case "d" : System.out.println("Enter Account No & Amount\n");
						ac1=in.nextInt();
						amo1=in.nextDouble();
						bank.deposit(ac1,amo1) ;
						break;
			case "c" : System.out.println("Enter Name & Opening balance amount\n");						
						name1=in.next();
						amo1=in.nextDouble();
						bank.CreateAccount(name1,amo1);
					    break;
			case "w" : System.out.println("Enter Account No & Amount to Withdraw\n");
						ac1=in.nextInt();
						amo1=in.nextDouble();
						bank.withdraw(ac1,amo1);
						break;
			case "b" : System.out.println("Enter Account No \n");
						ac1=in.nextInt();
						bank.display(ac1);
						break;
			case "l" : bank.AccountsList();
					   break;
			case "x":	opt="x";
						
			
			}
		}
		in.close();
	}
}
