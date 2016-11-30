package database2;

public class ServSocketUpdateGroup extends ServSocket {

	 public ServSocketUpdateGroup(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };

}
