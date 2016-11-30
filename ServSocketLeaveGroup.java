package database2;

public class ServSocketLeaveGroup extends ServSocket {

	 public ServSocketLeaveGroup(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };
}
