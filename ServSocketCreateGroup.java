package database2;

public class ServSocketCreateGroup extends ServSocket {

	 public ServSocketCreateGroup(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };

}
