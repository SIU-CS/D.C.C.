
public class UserList {
	UserProfile first;
	int TotalUsers;
	
	public UserList(){
		TotalUsers=0;
	}
	
	public void AddUser(UserProfile user){
		if(TotalUsers==0){
			first=user;
			user.NextUser=null;
		}
		else{
		user.NextUser=first;
		first=user;
		}
	}
}
