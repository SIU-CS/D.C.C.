package database2;

public class ServSocketSearchGroup extends ServSocket {

	 public ServSocketSearchGroup(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };
}
