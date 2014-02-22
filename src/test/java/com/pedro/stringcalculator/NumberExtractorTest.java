package com.pedro.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test created to check the correctness of NumberExtractorTest
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NumberExtractorTest {

    /*
     * Constants
     */

    private static final String NO_NUMBERS = "asdf";
    private static final String NUMBERS_WITH_DIFFERENT_DELIMITERS = "\n|·1,2,3,pouusdf4%5&6";


    /*
     * Test data
     */

    private NumberExtractor numberExtractor;

    /*
     * After and before methods
     */

    @Before
    public void setUp() {
        initializeNumberExtractor();
    }


    /*
     * Test methods
     */

    @Test
    public void shouldReturnAnEmptyCollectionIfTheParamIsNull() {
        List<Integer> result = numberExtractor.extract(null);
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnAnEmptyCollectionIfTheParamIsEmpty() {
        List<Integer> result = numberExtractor.extract("");
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnAnEmptyCollectionOfNumbersIfThereIsNoNumbersInsideTheString() {
        List<Integer> result = numberExtractor.extract(NO_NUMBERS);
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }

    @Test
    public void souldReturnACollectionWithTheNumbersExtracted() {
        List<Integer> result = numberExtractor.extract(NUMBERS_WITH_DIFFERENT_DELIMITERS);
        List<Integer> expectedResult = generateListOfNumbers(1, 2, 3, 4, 5, 6);
        assertEquals(expectedResult, result);
    }

    /*
     * Auxiliary method
     */

    private void initializeNumberExtractor() {
        numberExtractor = new NumberExtractor();
    }

    private List<Integer> generateListOfNumbers(Integer... nums) {
        List<Integer> result = new LinkedList<Integer>();
        for (Integer num : nums) {
            result.add(num);
        }
        return result;
    }
}
