

import java.util.Scanner;


public class StudyHub {
	String first_name;
	String last_name;
	String user_input;
	String email;
	
				
	public static void main(String[] args) {
	
		UserList userlist = new UserList();
		Scanner user_input = new Scanner(System.in);
		String user;
		
		System.out.println("Are you a new or returning user /nEnter 'new' or 'returning'");
		user=user_input.nextLine();
		if(user=="new")
			UserProfile.CreateNewUser(userlist);
		else
			//user login

		String first_name;
		System.out.println("Enter your first name:");
		first_name = user_input.next();
		
		
		String last_name;
		System.out.println("Enter your last name");
		last_name = user_input.next();
		
		String email;
		System.out.println(" Enter you email address");
		email = user_input.next();
		
		
		String full_name;
		full_name = first_name  + "" + last_name + "" + email;
		
		System.out.println(" You are \n" + full_name);
	
		
	}
}