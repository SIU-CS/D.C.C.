import java.lang.Thread;
public class UserExecute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Thread threadA = new Thread(new UserT("userA"));
     Thread threadB = new Thread(new UserT("userB"));
     Thread threadC = new Thread(new UserT("userC"));
     Thread threadD = new Thread(new UserT("userD"));
     
     
     threadA.start();
     threadB.start();
     threadC.start();
     threadD.start();
     
     System.out.print("The task has arrived");
	}

}
