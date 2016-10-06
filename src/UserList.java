
public class UserList {
	UserProfile first;
	int TotalUsers;
	
	public UserList(){
		TotalUsers=0;
		first=null;
	}
	
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
}
