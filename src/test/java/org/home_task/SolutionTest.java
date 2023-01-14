package org.home_task;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * Unit test for Solution class.
 */
public class SolutionTest extends TestCase
{
    /**
     * Testing a valid input.
     */
    public void testInput1(){
        Solution solution = new Solution("23");
        List<String> test = List.of(new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"});
        assertEquals(solution.returnResult(), test);
    }

    /**
     * Testing input with length 1. Input is valid.
     */
    public void testInput2(){
        Solution solution = new Solution("3");
        List<String> test = List.of(new String[]{"d","e","f"});
        assertEquals(solution.returnResult(), test);
    }

    /**
     * Testing a valid input. The sorting is checked as well.
     */
    public void testInput3(){
        Solution solution = new Solution("32");
        List<String> test = List.of(new String[]{"da","db","dc", "ea", "eb", "ec", "fa", "fb", "fc"});
        List<String> test1 = List.of(new String[]{"ad","ae","af", "bd", "be", "bf", "cd", "ce", "cf"});
        assertEquals(solution.returnResult(), test1);
        assertNotSame(solution, test);
    }

    /**
     * Testing input with unsorted values. The result is returned in sorted order.
     */
    public void testUnsortedInput(){
        Solution solution = new Solution("54");
        List<String> test = List.of(new String[]{"gj","gk","gl", "hj", "hk", "hl", "ij", "ik", "il"});
    }

    /**
     * Testing input containing value '1', which is invalid. Exception is thrown.
     */
    public void testInputWithValue1(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Solution solution = new Solution("123");
        });
        Assertions.assertEquals("Input should consist of numeric values only!", thrown.getMessage());
    }

    /**
     * Testing input with length longer than 4. Input is invalid. Exception is thrown.
     */
    public void testInputWithValueLongerThan4Elements(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Solution solution = new Solution("23456");
        });
        Assertions.assertEquals("Length of the input should be less than or equal 4!", thrown.getMessage());
    }
}
