import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorPositiveTest {
    private Calculator calculator;

    @Before
    public void initTest() {
        calculator = new Calculator();
    }


    @After
    public void afterTest() {
        calculator = null;
    }


    @Test
    public void testIntegerNumDiv() throws Exception {
        assertEquals("10.00", calculator.div("1000", "100"));
        assertEquals("0.10", calculator.div("100", "1000"));

        assertEquals("1.00", calculator.div("1", "1"));
        assertEquals("1.00", calculator.div("1000", "1000"));
        assertEquals("0.00", calculator.div("0", "1000"));


        assertEquals("-200.00", calculator.div("-1000", "5"));
        assertEquals("-200.00", calculator.div("1000", "-5"));
        assertEquals("200.00", calculator.div("-1000", "-5"));


        assertEquals("-0.01", calculator.div("-5", "1000"));
        assertEquals("-0.01", calculator.div("5", "-1000"));
        assertEquals("0.01", calculator.div("-5", "-1000"));

    }


    @Test
    public void testNumbersWithDot() throws Exception {
        assertEquals("0.33", calculator.div("33.33", "100"));
        assertEquals("3.00", calculator.div("100", "33.33"));
        assertEquals("3.02", calculator.div("100.5", "33.33"));
        assertEquals("1.00", calculator.div("33.33", "33.33"));

        //Округление
        assertEquals("12.00", calculator.div("11.999", "1"));
        assertEquals("11.56", calculator.div("11.555", "1"));
        assertEquals("11.55", calculator.div("11.554", "1"));
        assertEquals("11.11", calculator.div("11.111", "1"));
        assertEquals("11.00", calculator.div("11.001", "1"));
    }


    @Test
    public void testNumbersWithDotAndMinus() throws Exception {
        assertEquals("-3.02", calculator.div("-100.5", "33.33"));
        assertEquals("-3.02", calculator.div("100.5", "-33.33"));
        assertEquals("3.02", calculator.div("-100.5", "-33.33"));
    }


    @Test
    public void testLongNum() throws Exception {
        String maxLongNum = "999999999999999";
        String minLongNum = "-99999999999999";
        String maxLongNumWithDot = "9999999999999.9";
        String minLongNumWithDot = "-999999999999.9";

        assertEquals("-10.00", calculator.div(maxLongNum, minLongNum));
        assertEquals("-0.10", calculator.div(minLongNum, maxLongNum));

        assertEquals("-0.10", calculator.div(minLongNumWithDot, maxLongNumWithDot));

        assertEquals("100.00", calculator.div(maxLongNum, maxLongNumWithDot));
        assertEquals("100.00", calculator.div(minLongNum, minLongNumWithDot));

        assertEquals("-1000.00", calculator.div(maxLongNum, minLongNumWithDot));
        assertEquals("-10.00", calculator.div(minLongNum, maxLongNumWithDot));

    }

    /*public static void main(String[] args) {

        JUnitCore runner = new JUnitCore();
        Result result = runner.run(CalculatorPositiveTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }*/

}