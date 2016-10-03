import java.util.Scanner;
public class UserProfile implements User{
	String Firstname, Lastname , E_Mail, Password; 
	
	public UserProfile(String First, String Last, String mail, String password){
	Firstname = First;
	Lastname = Last;
	E_Mail=mail;
	Password=password;
	}
	

	public void CreateNewUser(){
		boolean PasswordCheck=false;
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your First name");
		String First =scan.nextLine();
		System.out.println("What is your Last name");
		String Last = scan.nextLine();
		System.out.println("What is your E_Mail");
		String Mail = scan.nextLine();
		System.out.println("What is your Password");
		while(PasswordCheck==false){
			String Password=scan.nextLine();
			System.out.println("Please retype your Password to confirm");
			String Password2=scan.nextLine();
			if (Password==Password2)
				PasswordCheck=true;
			else
				System.out.println("Error:Passwords do not match. Please reenter your first password");
			
		}
		
	}

}
