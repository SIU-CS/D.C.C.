import static org.junit.Assert.*;
import java.util.Scanner;

import org.junit.Test;

public class GroupTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void NewGroup() {
		Scanner scan = new Scanner(System.in);
		String name;
		String college;
		System.out.println("What is the name of the new group?");
		name=scan.nextLine();
		System.out.println("What is the College of the subject");
		Group.IsACollege(college);
		fail("Not yet implemented");
	}
	
	@Test
	public boolean IsACollege(String college){
		return(college=="Agricultural Sciences"||college=="Applied Sciences and Arts"||college=="Business"||college=="Education and Human Services"||college=="Engineering"||college=="Liberal Arts"||college=="Mass Communication & Media Arts"||college=="Science"||college=="School of Law"||college=="School of Medicine");
	}
	
}
