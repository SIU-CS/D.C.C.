package database2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ServSocket s1 = new ServSocket(1342);
		ServSocket s2 = new ServSocketAddUser(1343);
		ServSocket s3 = new ServSocket(1344);
		ServSocket s4 = new ServSocket(1345);
		s1.start();
		s2.start();
		s3.start();
		s4.start();
	}

}
