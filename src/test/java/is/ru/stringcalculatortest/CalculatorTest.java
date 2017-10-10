package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{
    @Test
    public void testEmptyString(){
        assertEquals(0,Calculator.add(""));
    }

    @Test
    public void testOneNumber(){
        assertEquals(1,Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers(){
        assertEquals(3,Calculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbers(){
        assertEquals(6,Calculator.add("1,2,3"));
    }

    @Test
    public void testMultipleNumbersWithZeroAndDoubleDigetNumbers(){
        assertEquals(22,Calculator.add("3,3,4,0,1,11"));
    }

    @Test
    public void testNewlineBetweenNumbers(){
        assertEquals(6,Calculator.add("1\n2,3"));
    }

    @Test
    public void ignoreNegativeNumber(){
        RuntimeException exception = null;
        try{
            Calculator.add("-1,2");
        } catch(IllegalArgumentException e){
            exception = e;
        }
        assertEquals(exception.getMessage(), "Negatives not allowed: -1");
    }

    @Test
    public void ignoreMultipleNegativeNumbers(){
        RuntimeException exception = null;
        try{
            Calculator.add("-1,2,3,-4,-5");
        } catch(IllegalArgumentException e){
            exception = e;
        }
        assertEquals(exception.getMessage(), "Negatives not allowed: -1,-4,-5");
    }

    @Test
    public void ignoreNumbersBiggerThenThousand(){
        assertEquals(2,Calculator.add("1001,2"));
    }

    @Test
    public void testDifferentdelimiter(){
        assertEquals(3,Calculator.add("//;\n1;2"));
    }
}