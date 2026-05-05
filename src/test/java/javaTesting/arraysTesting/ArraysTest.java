package javaTesting.arraysTesting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraysTest {

    @Test
    public void simpleArrayExample(){
        String[] numerals = {"zero", "one", "two", "three"};

        // assertEquals("zero", numerals[0]);
        String numbers = "";

        for(String each : numerals){
            numbers += each + "|";
        }

        assertEquals(numbers, "zero|one|two|three|");
    }

    @Test
    public void arrayIsOrdered(){
        String[] numerals = {"zero", "one", "two", "three"};

        Arrays.sort(numerals);
        for(int i = 0; i < numerals.length -1; i++){
            assertTrue(numerals[i].compareTo(numerals[i+1]) < 0);
        }
    }

    @Test
    public void fillsArrayPartially(){
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.fill(numbers, 5, 10, -1);

        for(int i = 5; i < numbers.length; i++){
            assertTrue(numbers[i] == -1);
        }
    }

    @Test
    public void copiesFromAnIndex(){
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        String[] workDays = Arrays.copyOfRange(days, 0, 5);
        assertTrue(workDays.length == 5);
        assertTrue(workDays[1].equals("Tuesday"));

        String[] slaveWorkDays = Arrays.copyOfRange(workDays, 0, 7);
        assertTrue(slaveWorkDays[0].equals("Monday"));
        assertEquals(slaveWorkDays[5], null);
        assertEquals(slaveWorkDays[6], null);

        slaveWorkDays[5] = "saturdayWorkDay";
        slaveWorkDays[6] = "restDay";

        assertTrue(slaveWorkDays[6].equals("restDay"));

    }

    @Test
    public void irregularArrayTest(){
        int[][] irrArray = {
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3},
                {0, 1, 2},
                {0, 1},
                {0}
        };

        assertEquals(irrArray.length, 6);
        assertEquals(irrArray[0].length, 6);
        assertEquals(irrArray[5].length, 1);

    }
}
