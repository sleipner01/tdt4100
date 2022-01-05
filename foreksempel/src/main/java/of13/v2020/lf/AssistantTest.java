package of13.v2020.lf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class AssistantTest {
	
	private Assistant assistant;
	
	@Before
	public void setUp() {
		assistant = new Assistant("Halvard");
	}
	
	@Test
	public void testRole() {
		assertEquals("The role of an assistant should always be \"Assistant\"", assistant.getRole(), "Assistant");
	}
	
	@Test
	public void testCanPerformTask() {
		assertTrue("An assistant should always be able to arrange meetings", assistant.canPerformTask("Arrange meeting"));
		assertTrue("An assistant should always be able to send emails", assistant.canPerformTask("Send email"));
		assertFalse("An assistant should not be able to fire an employee", assistant.canPerformTask("Fire employee"));
	}
	
	@Test
	public void testPerformValidTask() {
		assistant.performTask("Arrange meeting");
		assistant.performTask("Send email");
	}
	
	@Test
	public void testPerformInvalidTask() {
		try {
			assistant.performTask("Fire employee");
			fail("An assistant should not be able to fire employees");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPerformInvalidTask2() {
		assistant.performTask("Fire employee");
	}

}
