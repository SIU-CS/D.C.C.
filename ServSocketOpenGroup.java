package database2;

public class ServSocketOpenGroup extends ServSocket {

	 public ServSocketOpenGroup(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };

}
