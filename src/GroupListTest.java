import static org.junit.Assert.*;

import org.junit.Test;

public class GroupListTest {

	@Test
	public void testGroupList() {
		GroupList grouplist = new GroupList();
		assertEquals(0,grouplist.totalgroups);
	}

	@Test
	public void testAddgroup() {
		GroupList grouplist = new GroupList();
		UserProfile user =new UserProfile("cole","L","Random@siu.edu","password");
		Group group = new Group("Math280", user, "Other", "what description" );
		grouplist.addgroup(group);
		Group group1 = new Group("CS305", user, "Other", "Best class ever! Can i get bonus points for"
				+ "this :) im ganna need them" );
		grouplist.addgroup(group1);
		Group group2 = null;
		assertNotSame(group2,grouplist.firstgroup.nextgroup);
	}

	@Test
	public void testRemovegroup() {
		fail("Not yet implemented");
	}

}
