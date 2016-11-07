

import java.util.LinkedList;

public class Green {
	
		public static void main(String[] args)
				throws InterruptedException
		{
			final GO go = new GO();
			
			Thread g1 = new Thread(new Runnable() 
			{
				public void run()
				{
					try {
						go.produce();
					}
					catch(InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	
			
		});
	
Thread g2 = new Thread(new Runnable() {
	    @Override
		public void run()
		{ 
			try 
			{
				go.consume();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			}
		});
	g1.start();
	g1.start();
	
	g1.join();
	g1.join();
}
public static class GO {
	LinkedList<Integer> list = new LinkedList<>();
	int capacity = 3;
	
	public void produce() throws InterruptedException
	{
		int value = 0;
		while(true) {
			synchronized(this) {
				
				while(list.size()== capacity)
					wait();
				// Reserach that component //
				System.out.print("  The producer produced" + value);
			
	list.add(value++);
	
	notifyAll();
	
	Thread.sleep(25000);
			}
			
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized(this) {
				while (list.size()== 0)
					wait();
				int value = list.removeFirst();
				
				System.out.printf(" Consumer is done conusming" + value);
				
				notifyAll();
				
			Thread.sleep(2500);
			}
		}
	}
}
}