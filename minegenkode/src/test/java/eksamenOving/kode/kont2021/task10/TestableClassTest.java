package eksamenOving.kode.kont2021.task10;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 
public class TestableClassTest {

    private final Integer testInteger = 1;
    private final String testString = "Exam";

    private TestableClass tc = new TestableClass(testInteger, testString);
 
    @Test
    public void testIsMyStringEqualsToYieldsWrongResult() {
        assertTrue(tc.isMyStringEqualTo(testString));

        String testString2 = new String(testString);
        assertTrue(tc.isMyStringEqualTo(testString2), testString2 + " should be equal to " + testString);
    }
 
    @Test
    public void testIncrementIntegerHandlesEdgeCases() {
        TestableClass test = new TestableClass(null, "test");
        Assertions.assertNull(test.getMyIntegerIncrement());
    }
}
