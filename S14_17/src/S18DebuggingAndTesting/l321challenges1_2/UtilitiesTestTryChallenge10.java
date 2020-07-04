package S18DebuggingAndTesting.l321challenges1_2;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilitiesTestTryChallenge10 {
    private Utilities utilities;
    private String original;
    private String expected;

    public UtilitiesTestTryChallenge10(String original, String expected) {
        this.original = original;
        this.expected = expected;
    }

    // challenge 9
    @org.junit.Before
    public void beforeExecution(){
        utilities = new Utilities();
        System.out.println("EXECUTION BEFORE EACH METHOD");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"A", "A"}
        });
    }

    @org.junit.Test
    public void testParameters(){
        assertEquals(expected, utilities.removePairs(original));
    }

}