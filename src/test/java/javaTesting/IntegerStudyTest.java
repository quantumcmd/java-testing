package javaTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerStudyTest {

    @Test
    public void integerStudy(){
        Integer eight = new Integer(8);
        Integer thirteen = 13;
        int expected = 13;

        assertEquals(expected, thirteen.intValue(), "The number thirteen actually equals 13");

    }
}
