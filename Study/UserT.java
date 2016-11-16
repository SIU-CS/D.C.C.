import java.util.Random;
public class UserT implements Runnable  {

	private final int sleepTime;
	private final String taskUser;
	private final Random generator = new Random();
	
	public UserT (String user)
	{
		taskUser = user;
	sleepTime = generator.nextInt(5000);
	}
	
	public void run() {
		
		{
			try {
				System.out.printf("%s I am about to go to sleep now \n"
						+ taskUser, sleepTime);
				Thread.sleep(sleepTime);
			}
			catch(InterruptedException exception)
			{
				System.out.printf("%s %s\n", taskUser, "This will promptly terminate");
			}
			System.out.printf("%s sleeping now\n", taskUser);
		}
	}
}


