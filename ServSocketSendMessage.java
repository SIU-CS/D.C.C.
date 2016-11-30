package database2;

public class ServSocketSendMessage extends ServSocket {

	 public ServSocketSendMessage(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };
}
