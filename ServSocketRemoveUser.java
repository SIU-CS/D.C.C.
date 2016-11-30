package database2;

public class ServSocketRemoveUser extends ServSocket {

	 public ServSocketRemoveUser(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };

}
