package Banking;

import java.util.ArrayList;

public class Banking {
	int Ac=1006;
	int w=0;
	ArrayList<prototype> users=new ArrayList<>();

	public Banking() {
		users.add(new prototype(1001,"aaa",2000));
		users.add(new prototype(1002,"aab",2000));
		users.add(new prototype(1003,"aac",2000));
		users.add(new prototype(1004,"aad",2000));
		users.add(new prototype(1005,"aae",2000));
	}

	public void CreateAccount(String nam,double amo)
	{
		users.add(new prototype(Ac,nam,amo));
		System.out.println("Account Created Successfully:"+Ac);
		Ac++;
	}
	
	public void deposit(int acn,double amo)
	{ w=0;
		try {
		for(prototype emp:users)
		{
			if(emp.AcNo==acn)
			{
				emp.Bal+=amo;
				System.out.println("Transaction Successful");
				System.out.println("The available updated balance is:"+emp.Bal);
				w=1;
			}
			
		}
		if(w==0) {throw new AccountNotFoundException(); 		//try {
			}
		}catch(AccountNotFoundException e){
			System.out.println(e+"\n");
		}
		}
	
	public void withdraw(int acn, double amo) {
		w=0;
try {
		for(prototype emp:users)
		{
			if(emp.AcNo==acn)
			{
				if(emp.Bal>=amo)
				{
					emp.Bal-=amo;
					System.out.println("Transaction Successful");
					System.out.println("The Available Updated balance is:"+emp.Bal);
					w=1;
				}else {
					System.out.println("Insufficent Funds");
					w=1;
				}
			}
		}if(w==0)
			throw new AccountNotFoundException();
		}catch(AccountNotFoundException e){
			System.out.println(e+"\n");
		}
		}
	
	public void display(int acn) {
		w=0;
		try {
		for(prototype emp:users)
		{
			if(emp.AcNo==acn)
			{
				System.out.println("The available balance is:"+emp.Bal);
				w=1;
			}	
		}if(w==0) 
			throw new AccountNotFoundException();
		}catch(AccountNotFoundException e){
			System.out.println(e+"\n");
		}
		}
		
	public void AccountsList() {
	for (prototype emp : users) 
		System.out.println(emp.getAcNo()+" "+emp.getName());
		System.out.print("\n");
	}	
	}