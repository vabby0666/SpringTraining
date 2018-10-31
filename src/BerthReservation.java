import java.util.Scanner;

public class BerthReservation implements Runnable {
	int n=10;
	Scanner in=new Scanner(System.in);
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println("Welcome "+Thread.currentThread().getName());
		if(n>0) {
		System.out.println("The Number of Berths Available are:"+n);
		reserve();
		}
		else
			System.out.println("No Berths Available");		
	}
	public void reserve() {
		System.out.println("Enter Number of Tickets to book");
		int b=in.nextInt();
		if(b<=n) {
			n=n-b;
			System.out.println("Number of Tickets Allotted are:"+b);
			System.out.println("----------------------------------");
			System.out.println("\n");
			
			
		}
		else {
			System.out.println("Berths you want to book are more than the available");
		}
			
	}
}
