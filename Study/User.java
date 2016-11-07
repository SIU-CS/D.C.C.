import java.util.List;

public interface User {
	boolean addToGroup(Group g);
	boolean isMember(Group g);
	boolean removeFromGroup(Group g);
	List GetGroups();
	List GetCreatedGroups();
	boolean createGroup(String name);
	boolean removeGroup(String name);
	
}
