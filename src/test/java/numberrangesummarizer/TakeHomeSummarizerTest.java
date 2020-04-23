package numberrangesummarizer;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TakeHomeSummarizerTest
{

    TakeHomeSummerizer summerizer = new TakeHomeSummerizer();

    /**
     * Text collect - empty string case
     * Empty Stirng should return empty collection
     */
    @Test
    public void collectInput_EmptyString_ShouldReturnEmptyCollection()
    {   
        String numbersToParse = "";
        List<Integer> delimetedStringAsList = new  ArrayList<Integer>(summerizer.collect(numbersToParse)) ;
        assertTrue(delimetedStringAsList.isEmpty());
    }

    /**
     * Test collect - incorrect string format
     * Should throw NumberFormatException
     */
    @Test(expected = NumberFormatException.class)
    public void collectInput_StringIsWrongFormat_ShouldThrowException()
    {   
        String numbersToParse = "1/2,3jf";
        summerizer.collect(numbersToParse);
    }

    /**
     * Text summarize - given general case
     * Input  - [1,3,6,7,8,12,13,14,15,21,22,23,24,31]
     * Expected - "1, 3, 6-8, 12-15, 21-24, 31"
     */
    @Test
    public void summarize_GeneralGivenTest()
    {   
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31)); 
        String response = summerizer.summarizeCollection(input);
        assertTrue("1, 3, 6-8, 12-15, 21-24, 31".equals(response));
    }

    /**
     * Text summarize - empty list case
     * Input  - []
     * Expected - ""
     */
    @Test
    public void summarize_nullTest()
    {   
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList()); 
        String response = summerizer.summarizeCollection(input);
        assertTrue("".equals(response));
    }


    /**
     * Text summarize - some elmenets are out of order
     * Input  - [1,3,5,4,6]
     * Expected - "1, 3, 5, 4, 6"
     */
    @Test
    public void summarize_nonInOrderTest()
    {   
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,3,5,4,6)); 
        String response = summerizer.summarizeCollection(input);
        assertTrue("1, 3, 5, 4, 6".equals(response));
    }

     /**
     * Text summarize - elements that are only a sequence of two
     *                  should still show as a sequence
     * Input  - [1,2,5,6,7]
     * Expected - "1-2, 5-7"
     */
    @Test
    public void summarize_sequenceOfTwoTest()
    {   
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,5,6,7)); 
        String response = summerizer.summarizeCollection(input);
        assertTrue("1-2, 5-7".equals(response));
    }

    /**
     * Text summarize - no sequence
     * Input  - [1, 3, 5, 7, 9]
     * Expected - "1, 3, 5, 7, 9"
     */
    @Test
    public void summarize_noSequenceTest()
    {   
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,3,5,7,9)); 
        String response = summerizer.summarizeCollection(input);
        assertTrue("1, 3, 5, 7, 9".equals(response));
    }

    /**
     * Text summarize - only sequence
     * Input  - [1,2,3,4,5]
     * Expected - "1, 2, 3, 4, 5"
     */
    @Test
    public void summarize_onlySequenceTest()
    {   
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5)); 
        String response = summerizer.summarizeCollection(input);
        assertTrue("1-5".equals(response));
    }

    /**
     * Text summarize - no sequence
     * Input  - [1,1,1,1,1]
     * Expected - "1, 1, 1, 1, 1"
     */
    @Test
    public void summarize_repeatingElementTest()
    {   
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,1,1,1,1)); 
        String response = summerizer.summarizeCollection(input);
        assertTrue("1, 1, 1, 1, 1".equals(response));
    }
    
    
}
