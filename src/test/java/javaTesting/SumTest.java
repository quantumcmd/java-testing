package javaTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void sumTest(){
        int r = 1 + 1;
        // JUnit 5: assertEquals(Expected, Actual, Message)
        assertEquals(2, r, "1 + 1 = 2");
    }
}
