import static org.junit.Assert.*;
import java.util.Scanner;

import org.junit.Test;

public class GroupTest {

	@Test
	public void NewGroupTest() {
		GroupList grouplist = new GroupList();
		UserProfile user =new UserProfile("cole","L","Random@siu.edu","password");
		Group.NewGroup(user, grouplist);
		assertSame(user, grouplist.firstgroup.Leader);
		assertEquals("Other",grouplist.firstgroup.college);
	}
	
	@Test
	public void IsACollegeTest(){
		Boolean check =Group.IsACollege("Science");
		assertEquals(true,check);
	}
	
}
