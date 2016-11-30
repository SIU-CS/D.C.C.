package database2;

public class ServSocketLookDescription extends ServSocket {

	 public ServSocketLookDescription(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };
}
