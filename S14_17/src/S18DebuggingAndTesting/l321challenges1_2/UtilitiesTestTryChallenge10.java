package S18DebuggingAndTesting.l321challenges1_2;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilitiesTestTry {
    private Utilities utilities;
    private String msgNotImplemented = "******This test has not been implemented******";
    private String original;
    private String expected;

    public UtilitiesTestTry(String original, String expected) {
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
                {"ABCCABDEEF", true, "ABCABDEF"},
        });
    }

    @org.junit.Test
    public void testParameters(){
        assertEquals(expected, utilities.removePairs(original));
    }

    // challenge 4
    @org.junit.Test
    public void everyNthChar() {
        assertArrayEquals(new char[]{'e','l'}, utilities.everyNthChar(new char[]{'h','e','l','l','o'}, 2));
    }

    // challenge 5
    @org.junit.Test
    public void everyNthCharChall5() {
        char [] sourceArray = new char[]{'a','b','c','d'};
        assertArrayEquals(sourceArray, utilities.everyNthChar(sourceArray, 10)); // more than the length
    }

    // challenge 2
    @org.junit.Test
    public void removePairs() {
        String testString = utilities.removePairs("AABCDDEFF");
        assertEquals("ABCDEF", testString);
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
    }

    //challenge 3
    @org.junit.Test
    public void removePairsChallenge3() {
        assertEquals("A", utilities.removePairs("A")); // less than 2 test
        assertNull(null, utilities.removePairs(null)); // Null
        //assertNull("Did not get null retrurned", utilities.removePairs(null));
    }

    //challenge 7
    @org.junit.Test
    public void converter() {
        assertEquals(300, utilities.converter(10,5));
    }

    //challenge 8
    @org.junit.Test(expected = ArithmeticException.class)
    public void converterChall8() throws Exception{
        utilities.converter(10,0);
    }


    // challenge 6
    @org.junit.Test
    public void nullIfOddLength() {
        assertEquals("abcd", utilities.nullIfOddLength("abcd"));
        assertNull(utilities.nullIfOddLength("abcde"));
    }
}