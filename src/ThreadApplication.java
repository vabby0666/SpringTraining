
public class ThreadApplication {
public static void main(String args[]) {
	numbers num=new numbers();
	Thread t1=new Thread(num);
	Thread t2=new Thread(num);
	Thread t3=new Thread(num);
	t1.setName("AA");
	t2.setName("BB");
	t3.setName("CC");
	
	t1.start();
	t2.start();
	t3.start();
}
}
