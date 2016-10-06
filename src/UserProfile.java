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
//need to talk about how people are logged in and such
	public void LogIn(){
		String password;
		String email;
		Scanner scan=new Scanner(System.in);
		System.out.println("What is your E-mail address");
		email=scan.nextLine();
		UserProfile user = UserList.SearchUser(email);
		while(1!=0){
			System.out.println("Please Enter the password or enter cancel to exit");
			password=scan.nextLine();
			if(password==user.Password)
				break;
			else
		}
	}
}
