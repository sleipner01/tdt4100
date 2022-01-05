package of13.v2020.lf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TemporaryEmployeeTest {

	private TemporaryEmployee temp;
	
	@Before
	public void setUp() {
		temp = new TemporaryEmployee("Halvard", "Vitass", 1);
	}
	
	@Test
	public void testGetRole() {
		assertEquals("A temporary employee should have the role given in the constructor", temp.getRole(), "Vitass");
	}
	
	@Test
	public void testCanPerformTask() {
		assertTrue("A temporary employee with remaining tasks should be able to perform any task", temp.canPerformTask("Test task"));
		
		TemporaryEmployee temp2 = new TemporaryEmployee("Magnus", "Vitass", 0);
		assertFalse("A temporary employee with no remaining tasks should not be able to perform a task", temp2.canPerformTask("Test task"));
	}
	
	@Test
	public void testPerformTask() {
		try {
			temp.performTask("Test task");
		} catch (IllegalArgumentException | IllegalStateException e) {
			fail("A temporary employee with remaining tasks should be able to perform any task");
		}
		
		assertEquals("A temporary employee with no remaining tasks should have its role set to \"Quit\"", temp.getRole(), "Quit");
		
		try {
			temp.performTask("Test task");
			fail("A temporary employee with no remaining tasks should not be able to perform any task");
		} catch (IllegalStateException e) {
			
		}
	}
	
	
	
}
