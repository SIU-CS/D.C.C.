package database2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServSocketLogin extends ServSocket {
	private int port;
	 public ServSocketLogin(int Port){
		 super(Port);
	 }
	 
	 protected int action(int number){
		number++; 
		 return 79;
	 };
	
}
