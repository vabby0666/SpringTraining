
public class Reservationportal extends BerthReservation {

public static void main(String args[]) {
	BerthReservation br=new BerthReservation();
	Thread t1=new Thread(br);
	Thread t2=new Thread(br);
	Thread t3=new Thread(br);
	t1.setName("A");
	t2.setName("B");
	t3.setName("C");
	
	t1.start();
	t2.start();
	t3.start();
}
}