package of13.v2020.lf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class BossTest {
	
	private Boss boss;

	@Before
	public void setUp() {
		Assistant assistant = new Assistant("Halvard");
		Assistant assistant1 = new Assistant("Magnus");
		
		boss = new Boss("Børge", assistant, assistant1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithoutSubordinates() {
		new Boss("Børge");
	}
	
	@Test
	public void testRole() {
		assertEquals("The role of a boss should always be \"Boss\"", boss.getRole(), "Boss");
	}
	
	@Test
	public void testCanPerformTask() {
		assertTrue("A boss should able to perform tasks that its subordinates can perform", boss.canPerformTask("Arrange meeting"));
		assertTrue("A boss should able to perform tasks that its subordinates can perform", boss.canPerformTask("Send email"));
		assertFalse("A boss should not able to perform tasks that its subordinates can not perform", boss.canPerformTask("Fire employee"));
	}
	
	@Test
	public void testPerformTask() {
		try {
			boss.performTask("Arrange meeting");
		} catch (IllegalArgumentException e) {
			fail("A boss should able to perform tasks that its subordinates can perform");
		}
		
		try {
			boss.performTask("Fire employee");
			fail("A boss should not able to perform tasks that its subordinates can not perform");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
}
