
public class GroupList {
	Group firstgroup;
	int totalgroups;
	
	public GroupList(){
	firstgroup=null;
	totalgroups=0;
	}
	
	public void addgroup(Group group){
		group.nextgroup=firstgroup;
		firstgroup=group;
		totalgroups++;
	}
	
	public void removegroup(Group group){
		if (firstgroup==group)
			firstgroup=firstgroup.nextgroup;
		
		else{
			Group currentgroup=firstgroup;
			while(currentgroup.nextgroup!=group){
				currentgroup=currentgroup.nextgroup;
			}
			currentgroup.nextgroup=currentgroup.nextgroup.nextgroup;
		}
	}

	
}
