//link list class
public class UserList {
	static UserProfile first;
	int TotalUsers;
	
	//link list made
	public UserList(){
		TotalUsers=0;
		first=null;
	}
	
	//link list starts
	public void AddUser(UserProfile user){
		user.NextUser=first;
		first=user;
	}
	
	public void RemoveUser(UserProfile user){
		if (first==user){
			UserProfile temp = first.NextUser;
			first.NextUser=null;
			first=temp;
		}
		else{
		UserProfile currentuser = first;
			while(currentuser.NextUser!=user){
			currentuser=currentuser.NextUser;
			}
		currentuser.NextUser=currentuser.NextUser.NextUser;
		}
	}
	public static UserProfile SearchUser(String mail){
		UserProfile currentuser=first;
		while(currentuser.E_Mail!=mail||currentuser!=null)
			currentuser=currentuser.NextUser;
		return currentuser;
	}
}
