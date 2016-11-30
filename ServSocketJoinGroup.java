package database2;

public class ServSocketJoinGroup extends ServSocket {

	 public ServSocketJoinGroup(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };
}
