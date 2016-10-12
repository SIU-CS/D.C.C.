import java.util.Scanner;
public class UserProfile implements User{
	String Firstname, Lastname , E_Mail, Password; 
	UserProfile NextUser;
	
	public UserProfile(String First, String Last, String mail, String password){
	Firstname = First;
	Lastname = Last;
	E_Mail=mail;
	Password=password;
	}
	

	//create a case for if the email is already being used
	public static void CreateNewUser(UserList list){
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
			String password=scan.nextLine();
			System.out.println("Please retype your Password to confirm");
			String Password2=scan.nextLine();
			if (password==Password2){
				PasswordCheck=true;
				UserProfile user=new UserProfile(First, Last, Mail, password);
				list.AddUser(user);
			}
			else
				System.out.println("Error:Passwords do not match. Please reenter your first password");
			
		}
		
	}
	
	//Possibly some stinky code. may need to add methods to shorten this method.
//need to talk about how people are logged in and such
	//Making this assuming that we return a userprofile for now. need to talk about how the users information will be sent to the main class
	public UserProfile LogIn(){
		String password;
		String email;
		UserProfile user;
		Scanner scan=new Scanner(System.in);
		
		while(1!=0){
			System.out.println("What is your E-mail address");
			email=scan.nextLine();
			user = UserList.SearchUser(email);
			if(email==user.E_Mail)
				break;
			else if(email=="cancel")
				return null;
			else
				System.out.println("Email is not in database.");
		}
		while(1!=0){
			System.out.println("Please Enter the password or enter cancel to exit");
			password=scan.nextLine();
			if(password==user.Password)
				break;
			else if(password=="cancel")
				return null;
			else
				System.out.println("Password Incorrect");
		}
		return user;
	}
}
