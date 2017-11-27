import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    private BigDecimal firstNum, secondNum, res;

    public String checkNumbers(String a, String b){
        if(isEmpty(a)) return "First number is empty.";
        if(isEmpty(b)) return "Second number is empty.";

        if(!checkLength(a)) return "First number is too long.";
        if(!checkLength(b)) return "Second number is too long.";

        if(isZero(b)) return "Division by zero is impossible.";

        if(!isNumber(a)) return "First number is not number.";
        if(!isNumber(b)) return "Second number is not number.";

        if(!isCorrectNum(a)) return "First number is incorrect format.";
        if(!isCorrectNum(b)) return "Second number is incorrect format.";

        firstNum = new BigDecimal(a);
        secondNum = new BigDecimal(b);
        return "Ok";
    }

    private boolean isZero(String str){
        if(str.length() == 1 && str == "0") return true;
        return false;
    }

    private boolean isEmpty(String str){
        if(str.length() == 0) return true;
        return false;
    }

    private boolean checkLength(String str){
        if(str.length() > 15) return false;
        return true;
    }


    private boolean isCorrectNum(String str){
        int lastIndex = str.length() - 1;
        if(str.charAt(0) == '.') return false;
        if(str.charAt(lastIndex) == '.') return false;
        if(str.length() >= 2 && str.charAt(0) == '0' && str.charAt(1) != '.') return false;
        if(str.length() >= 3 && str.charAt(0) == '-' && str.charAt(1) == '0' && str.charAt(2) != '.') return false;
        return true;
    }


    private boolean isNumber(String str){
        //разделитель - точка
        for(int i = 0; i<str.length(); ++i){
            boolean dot = false;
            if(str.charAt(i) < 58 && str.charAt(i) > 47) continue;
            else if(str.charAt(i) == '.'){
                if(dot) return false;
                else dot = true;
            }
            else if(str.charAt(i) == '-' && i == 0) continue;
            else return false;
        }
        return true;
    }

    public BigDecimal div(){
        return firstNum.divide(secondNum, 2, RoundingMode.HALF_UP);
    }

}
