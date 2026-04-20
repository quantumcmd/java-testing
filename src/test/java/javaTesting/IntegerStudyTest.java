package javaTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegerStudyTest {

    @Test
    public void integerStudy(){
        Integer thirteen = 13;
        int expected = 13;

        assertEquals(expected, thirteen.intValue(), "The number thirteen actually equals 13");

    }

    @Test
    public void integerComparationStudy(){
        Integer ocho = new Integer(8);
        Integer eight = new Integer("8");

        // assertTrue(ocho == eight, "The number 'ocho' equals the number 'eight'");
        assertTrue(ocho.equals(eight), "The number 'ocho' equals the number 'eight'");
        // assertTrue(condition) can be replaced with assertEquals(true, condition) i.e:
        // assertEquals(true, ocho.equals(eight));
    }

    @Test
    public void binaryStudy(){
        Integer two = new Integer(2);

        String people = "There are " + Integer.toBinaryString(two) + " types of people: Those who understand binary and those who don't";
        assertEquals(2, two.intValue(), people);
    }
}
