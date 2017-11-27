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

    @Test
    public void testZeroArg() throws Exception {
        assertEquals("Division by zero is impossible.", calculator.checkNumbers("10","0"));
        assertEquals("Division by zero is impossible.", calculator.checkNumbers("0","0"));
        assertEquals("Ok", calculator.checkNumbers("0","10"));

    }

    @Test
    public void emptyFields() throws Exception {
        assertEquals("First number field is empty.", calculator.checkNumbers("","10"));
        assertEquals("Second number field is empty.", calculator.checkNumbers("10",""));
    }

    @Test
    public void longNumber() throws Exception {
        assertEquals("First number is too long.", calculator.checkNumbers("1234567890123456","10"));
        assertEquals("Second number is too long.", calculator.checkNumbers("10","12345678901234566666"));
    }

    @Test
    public void notNumber() throws Exception {
        //символы
        assertEquals("First number is not number.", calculator.checkNumbers("abcd1234","10"));
        assertEquals("Second number is not number.", calculator.checkNumbers("10","1234ab^&*("));

        //две точки
        assertEquals("First number is not number.", calculator.checkNumbers("0.123.123","10"));
        assertEquals("Second number is not number.", calculator.checkNumbers("10","..12"));

        //минус не в начале
        assertEquals("First number is not number.", calculator.checkNumbers("45-12","10"));
        assertEquals("Second number is not number.", calculator.checkNumbers("10","11-11"));

        assertEquals("First number is not number.", calculator.checkNumbers("4.9e-324","10"));
        assertEquals("Second number is not number.", calculator.checkNumbers("10","4.9e-324"));

    }


    @Test
    public void incorrectFormatNumber() throws Exception {
        //точка в начале
        assertEquals("First number is incorrect format.", calculator.checkNumbers(".124","10"));
        assertEquals("Second number is incorrect format.", calculator.checkNumbers("10",".01"));

        //точка в конце
        assertEquals("First number is incorrect format.", calculator.checkNumbers("1255.","10"));
        assertEquals("Second number is incorrect format.", calculator.checkNumbers("10","14242453."));

        //00
        assertEquals("First number is incorrect format.", calculator.checkNumbers("0123","10"));
        assertEquals("Second number is incorrect format.", calculator.checkNumbers("10","000123"));

        //-00
        assertEquals("First number is incorrect format.", calculator.checkNumbers("-015","10"));
        assertEquals("Second number is incorrect format.", calculator.checkNumbers("10","-0000765"));

        //-.
        assertEquals("First number is incorrect format.", calculator.checkNumbers("-.124","10"));
        assertEquals("Second number is incorrect format.", calculator.checkNumbers("10","-.125774"));

    }
}