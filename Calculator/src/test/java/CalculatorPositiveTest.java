import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.math.BigDecimal;

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
    public void testDiv() throws Exception {
        assertEquals("Ok", calculator.checkNumbers("100", "10"));
        assertEquals(new BigDecimal("10.00"), calculator.div("100", "10"));

        assertEquals("Ok", calculator.checkNumbers("10", "100"));
        assertEquals(new BigDecimal("0.10"), calculator.div("10", "100"));

        assertEquals("Ok", calculator.checkNumbers("1", "1"));
        assertEquals(new BigDecimal("1.00"), calculator.div("1", "1"));

        assertEquals("Ok", calculator.checkNumbers("-10", "5"));
        assertEquals(new BigDecimal("-2.00"), calculator.div("-10", "5"));

        assertEquals("Ok", calculator.checkNumbers("10", "-5"));
        assertEquals(new BigDecimal("-2.00"), calculator.div("10", "-5"));

        assertEquals("Ok", calculator.checkNumbers("-10", "-5"));
        assertEquals(new BigDecimal("2.00"), calculator.div("-10", "-5"));

        assertEquals("Ok", calculator.checkNumbers("0", "10"));
        assertEquals(new BigDecimal("0.00"), calculator.div("0", "10"));

        assertEquals("Ok", calculator.checkNumbers("123456789012345", "12345"));
        assertEquals(new BigDecimal("10000549940.25"), calculator.div("123456789012345", "12345"));

        assertEquals("Ok", calculator.checkNumbers("123456789012345", "123456789012345"));
        assertEquals(new BigDecimal("1.00"), calculator.div("123456789012345", "123456789012345"));

    }


    @Test
    public void testDivWithDot() throws Exception {
        assertEquals("Ok", calculator.checkNumbers("100.10", "10"));
        assertEquals(new BigDecimal("10.01"), calculator.div("100.10", "10"));

        assertEquals("Ok", calculator.checkNumbers("100", "3"));
        assertEquals(new BigDecimal("33.33"), calculator.div("100", "3"));

        assertEquals("Ok", calculator.checkNumbers("1", "1.1"));
        assertEquals(new BigDecimal("0.91"), calculator.div("1", "1.1"));

    }


    public static void main(String []args){

        JUnitCore runner = new JUnitCore();
        Result result = runner.run(CalculatorPositiveTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

}