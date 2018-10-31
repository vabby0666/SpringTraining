
public class numbers implements Runnable {

		public synchronized void run()
		{
			System.out.println(Thread.currentThread().getName());
			for(int i=1;i<=5;i++)
				System.out.println(i+" ");
				try
				{
					Thread.sleep(5000);
				}catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			
		}
	
}