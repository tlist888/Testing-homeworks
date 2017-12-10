import Exceptions.EmptyFieldException;
import Exceptions.LeadingZeroExceptions;
import Exceptions.LongNumberException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class CalculatorNegativeTest {
    private Calculator calculator;

    @Before
    public void initTest() {
        calculator = new Calculator();
    }


    @After
    public void afterTest() {
        calculator = null;
    }


    @Test(expected = ArithmeticException.class)
    public void testZeroArg() throws Exception {
        assertEquals("0", calculator.div("1000", "0"));
        assertEquals("0", calculator.div("0", "0"));
    }


    @Test(expected = LeadingZeroExceptions.class)
    public void testLeadingZero() throws Exception {
        assertEquals("0", calculator.div("1000", "000"));
        assertEquals("0", calculator.div("000", "1000"));
        assertEquals("0", calculator.div("000", "000"));
        assertEquals("0", calculator.div("-015","1000"));
        assertEquals("0", calculator.div("1000","-0000765"));
    }


    @Test(expected = EmptyFieldException.class)
    public void testEmptyFields() throws Exception {
        assertEquals("0", calculator.div("", "1000"));
        assertEquals("0", calculator.div("1000", ""));
    }


    @Test(expected = LongNumberException.class)
    public void testLongNumber() throws Exception {
        //16 цифр
        assertEquals("0", calculator.div("1000", "1234567890123456"));
        assertEquals("0", calculator.div("1234567890123456", "1000"));

        //15 цифр с минусом
        assertEquals("0", calculator.div("1000", "-123456789012345"));
        assertEquals("0", calculator.div("-123456789012345", "1000"));

        //15 цифр с точкой
        assertEquals("0", calculator.div("1000", "123.456789012345"));
        assertEquals("0", calculator.div("123.456789012345", "1000"));

        //100 цифр
        String number = "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        assertEquals("0", calculator.div("1000", number));
        assertEquals("0", calculator.div(number, "1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void testNotNumber() throws Exception {
        //символы
        assertEquals("0", calculator.div("1000", "abcdf%$#@"));
        assertEquals("0", calculator.div("abcdf!#(_+", "1000"));

        //минус не в начале
        assertEquals("0", calculator.div("45-12","1000"));
        assertEquals("0", calculator.div("1000","11-11"));

        //несколько минусов
        assertEquals("0", calculator.div("-45-12","1000"));
        assertEquals("0", calculator.div("1000","1-1-1-1"));
    }


    @Test(expected = NumberFormatException.class)
    public void testWithDot() throws Exception {
        //точка в начале
        assertEquals("0", calculator.div(".124","1000"));
        assertEquals("0", calculator.div("1000",".01"));

        //точка в конце
        assertEquals("0", calculator.div("1255.","1000"));
        assertEquals("0", calculator.div("1000","14242453."));

        //несколько точек
        assertEquals("0", calculator.div("1.0.00","1000"));
        assertEquals("0", calculator.div("1000","1.00..00.00"));

    }

}