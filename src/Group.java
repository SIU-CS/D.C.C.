import java.util.List;
import java.util.Queue;


public class Group {
	String name;
	public List members, admins;

	public String[] messages;
	int mesNum; //Keeps track of the number of messages and where the Last message is.

	
	public Group(String name,User creator){
		setName(name);
		addAdmin(creator);
		addMember(creator);
		messages= new String[50];
	}
	
	
	
	//get/set Methods
	
	String getName(){
		return name;
	}
	void setName(String name){
		this.name=name;
	}
	
	List getMembers(){
		return members;
	}
	void addMember(User member){
		members.add(member);

	}
	void removeMember(User member){
		members.remove(member);			
	}
	
	List getAdmin(){
		return admins;
	}
	void addAdmin(User admin){
		admins.add(admin);
	}
	void removeAdmin(User admin){
		if(admins.size()>1){
		admins.remove(admin);
		}
	}
	
	String[] getMessages(){
		return messages;
	}
	void addMessage(String message){
		messages[mesNum]=message;
		if(mesNum!=49)mesNum++;
		else mesNum=0;
	}
	
}
