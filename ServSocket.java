package database2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServSocket extends Thread{
 protected int port;
 public ServSocket(int Port){
	 port = Port;
 }
 
 protected GenData action(GenData data){

	 return data;
 };
 
 protected static 
 
 protected static void InputData(ObjectInputStream objectInput){
	 GenData data = null;
		try {
			data = (GenData)objectInput.readObject();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 }
 
 public void run(){
		while(true){
	 ServerSocket s=null;
	try {
		s = new ServerSocket(port);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 int number;
		Socket ss = null;
		try {
			ss = s.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		Scanner scan = null;
		ObjectInputStream objectInput=null;
		try {
			objectInput = new ObjectInputStream(ss.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectOutputStream objectOutput=null;
		try {
			objectOutput = new ObjectOutputStream(ss.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ServSocket.InputData();
		
		
		GenData data = null;
		try {
			data = (GenData)objectInput.readObject();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		try {
//			scan = new Scanner(ss.getInputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		data=action(data);
		
//		PrintStream p = null;
//		try {
//			p = new PrintStream(ss.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			objectOutput.writeObject(data);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		p.println(number);
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
 }
}
