import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Group {
	String tag,name,description;
	public List members, admins;
	Group nextgroup;
	UserProfile Leader;
	

	public String[] messages;
	int mesNum; //Keeps track of the number of messages and where the Last message is.

	//problem with list of admins. creating a leader variable for now
	public Group(String name,UserProfile creator, String College, String Description){
		setName(name);
		tag = College;
		Leader=creator;
//		addAdmin(creator);
//		addMember(creator);
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
	void addAdmin(UserProfile admin){
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
		//SOME ARE ABREVIATED SO I PUT BOTH THE ABREVIATION AND NONABREVIATION
		//ALL ANDS HAVE BEEN CHANGED TO &
		String subjects[]={"ACCOUNTING", "ADVANCED ENERGY & FUELS MANAGEMENT", "ADVANCED ENERGY & FUELS MGMT", "AEROSPACE STUDIES", "AFRICANA STUDIES", "AGRIBUSINESS ECONOMICS", "ARGRICULTURAL SCIENCES", "AGRICULTURAL SYSTEMS & EDUCAT.", "AGRICULTURAL SYSTEMS & EDUCATION", "AGRICULTURE", "ALLIED HEALTH", "ANIMAL SCIENCE", "ANTHROPOLOGY", "ARCHITECTURAL STUDIES", "ARMY MILITARY SCIENCE", "ART AND DESIGN", "AUTOMOTIVE TECHNOLOGY", "AVIATION FLIGHT", "AVIATION MANAGEMENT", "AVIATION TECHNOLOGIES", "BEHAVIOR ANALYSIS AND THERAPY", "BIOCHEMISTRY", "BIOLOGY", "BIOMEDICAL ENGINEERING", "BUSINESS", "BUSINESS ADMINISTRATION", "CHEMISTRY AND BIOCHEMISTRY", "CHINESE", "CINEMA AND PHOTOGRAPHY", "CIVIL ENGINEERING", "CLASSICS", "COMMUNICATION DISORDERS & SCI.", "COMMUNICATION DISORDERS & SCIENCE", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "COUNSELING", "CRIMINOLOGY & CRIMINAL JUSTICE", "CROP, SOIL, ENVIRONMENTAL MGMT", "CROP, SOIL, ENVIRONMENTAL MANAGEMENT", "CURRICULUM AND INSTRUCTION", "DENTAL HYGIENE", "EAST ASIA", "ECONOMICS", "EDU. ADMIN. & HIGHER EDUC.", "EDUCATION ADMINISTRATION & HIGHER EDUCATION", "EDUCATION", "ELECTRICAL & COMPUTER ENGR.", "ELECTRICAL & COMPUTER ENGINEERING", "ELECTRONIC SYSTEMS TECHNOLGIES", "ENGINEERING", "ENGINEERING TECHNOLOGY", "ENGLISH", "ENVIRONMENTAL RESOURCES & POL.", "ENVIRONMENTAL RESOURCES & POLICY", "FASHION DESIGN & MERCHANDISING", "FERMENTATION SCIENCE", "FINANCE", "FIRE SCIENCE MANAGEMENT", "FOOD & NUTRITION", "FOREIGN LANGUAGES", "FORESTRY", "FRENCH", "GEOGRAPHY", "GEOLOGY", "GERMAN", "GERONTOLOGY", "HEALTH ADMINISTRATION", "HEALTH CARE MANAGEMENT", "HEALTH EDUCATION", "HEALTH INFORMATICS", "HISTORY", "HISOTECHNOLOGY", "HORTICULTURE", "HOSPITALITY & TOURISM ADMIN.", "HOSPITALITY & TOURISM ADMINISTRATION", "HUMAN NUTRITION & DIETETICS", "INDUSTRIAL MGMT & APPLIED ENG.", "INDUSTRIAL MANAGEMENT & APPLIED ENGINEERING};
		return(college=="Agricultural Sciences"||college=="Applied Sciences and Arts"
				||college=="Business"||college=="Education and Human Services"||college==
				"Engineering"||college=="Liberal Arts"||college=="Mass Communication & Media Arts"
				||college=="Science"||college=="School of Law"||college=="School of Medicine");
	}
	
	
	public static void NewGroup(UserProfile user, GroupList grouplist) {
		Scanner scan = new Scanner(System.in);
		String Name;
		String Collegetag;
		String Description;
		System.out.println("What is the name of the new group?");
		Name=scan.nextLine();
		System.out.println("What is the College of the subject. Leave "
				+ "blank or enter something else to select other as the tag.");
		Collegetag=scan.nextLine();
		if (!Group.IsACollege(Collegetag))
			Collegetag="Other";
		System.out.println("Please enter in a description of the group.");
		Description=scan.nextLine();
		Group newgroup = new Group(Name, user, Collegetag, Description);
		grouplist.addgroup(newgroup);
		
	}
}
