import Exceptions.EmptyFieldException;
import Exceptions.LeadingZeroExceptions;
import Exceptions.LongNumberException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * class Calculator
 * Выполняет деление двух чисел.
 * Формат разделителя для дробного числа - точка. При вводе числа допускаются только цифры, одна точка и один минус .
 * Максимальное число цифр в числе - 15 (вместе с точкой и минусом).
 * Результат вычисляется с точностью до 2 знаков после запятой.
 * Округление происходит до 2 знаков после запятой, по правиласм округления. Цифры от 0 до 4 - округляются в меньшую
 * сторону, от 5 до 9 - в большую.
 **/


public class Calculator {

    //проверка на 0, пустое поле, недопустимую длину, ведущие нули
    private void checkNumbers(String a, String b) throws EmptyFieldException, LongNumberException, ArithmeticException, LeadingZeroExceptions {
        if (isZero(b)) throw new ArithmeticException();

        if (isEmpty(a) || isEmpty(b)) throw new EmptyFieldException();

        if (!checkLength(a) || !checkLength(b)) throw new LongNumberException();

        if (isLeadingZero(a) || isLeadingZero(b)) throw new LeadingZeroExceptions();

        if(incorrectFormat(a) || incorrectFormat(b)) throw new NumberFormatException();

    }


    //проверка на 0
    private boolean isZero(String str) {
        if (str.equals("0")) return true;
        return false;
    }


    //проверка на пустое поле
    private boolean isEmpty(String str) {
        if (str.length() == 0) return true;
        return false;
    }


    //проверка на длину
    private boolean checkLength(String str) {
        if (str.length() > 15) return false;
        return true;
    }


    //проверка на ведущие 0
    private boolean isLeadingZero(String str) {
        int len = str.length();
        //00...
        if(len > 1 && str.charAt(0) == '0' && str.charAt(1) == '0') return true;
        //-0
        if(len == 2 && str.charAt(0) == '-' && str.charAt(1) == '0') return true;
        //-00...
        if(len > 2 && str.charAt(0) == '-' && str.charAt(1) == '0' && str.charAt(2) == '0') return true;

        return false;

    }

    //проверка на -.
    private boolean incorrectFormat(String str){
        if(str.length() > 2 && str.charAt(0) == '-' && str.charAt(1) == '.') return true;
        if(str.charAt(0) == '.') return true;
        return false;
    }

    /**
     * Метод, осуществляющий деление. Сначала методом checkNumbers осуществляется проверка чисел на:
     * длину,
     * пустые поля,
     * ведущие нули,
     * деление на 0
     *
     * @param a - делимое
     * @param b - делитель
     * @return - результат деления
     * При некорректных входных данных выбрасывает исключения, в зависимости от типа ошибки.
     */

    public String div(String a, String b) throws EmptyFieldException, LongNumberException, ArithmeticException, NumberFormatException, LeadingZeroExceptions {

        BigDecimal result;
        BigDecimal firstNum, secondNum;
        checkNumbers(a, b);

        firstNum = new BigDecimal(a);
        secondNum = new BigDecimal(b);
        result = firstNum.divide(secondNum, 2, RoundingMode.HALF_UP);
        return result.toString();

    }

}
