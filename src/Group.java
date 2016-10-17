import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Group {
	String college,name,description;
	public List members, admins;
	Group nextgroup;
	

	public String[] messages;
	int mesNum; //Keeps track of the number of messages and where the Last message is.

	
	public Group(String name,User creator, String College, String Description){
		setName(name);
		college = College;
		addAdmin(creator);
		addMember(creator);
		messages= new String[50];
		nextgroup=null;
		description=Description;
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
	
	
	public static boolean IsACollege(String college){
		return(college=="Agricultural Sciences"||college=="Applied Sciences and Arts"||college=="Business"||college=="Education and Human Services"||college=="Engineering"||college=="Liberal Arts"||college=="Mass Communication & Media Arts"||college=="Science"||college=="School of Law"||college=="School of Medicine");
	}
	
	
	public void NewGroup(User user, GroupList grouplist) {
		Scanner scan = new Scanner(System.in);
		String Name;
		String College;
		String Description;
		System.out.println("What is the name of the new group?");
		Name=scan.nextLine();
		System.out.println("What is the College of the subject. Leave blank or enter something else to select other as the tag.");
		College=scan.nextLine();
		if (!Group.IsACollege(College))
			College="Other";
		System.out.println("Please enter in a description of the group.");
		Description=scan.nextLine();
		Group newgroup = new Group(Name, user, College, Description);
		grouplist.addgroup(newgroup);
		
	}
}
